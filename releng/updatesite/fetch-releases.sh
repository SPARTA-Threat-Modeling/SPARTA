#!/usr/bin/env bash
#
# Materialize the SPARTA per-year p2 composite update sites on a web server.
#
# The composite metadata (one <year>/compositeContent.xml + compositeArtifacts.xml
# per release line) is built and committed to the gh-pages branch by CI. This
# script does NOT touch that metadata -- it only downloads and extracts the
# per-version p2 repositories each composite references, placing each under
# <year>/releases/<version>/ next to its composite. It needs nothing beyond a
# POSIX shell, curl (or the gh CLI) and unzip.
#
# Layout produced (serve the checkout root at .../updates/ so that, e.g.,
# .../updates/2026/ is the 2026 composite):
#   2026/compositeContent.xml            (committed by CI)
#   2026/releases/2026.1.0/              (fetched here)
#   2027/compositeContent.xml            (committed by CI)
#   ...
#
# Usage on the web server:
#   git clone --branch gh-pages --single-branch <repo-url> sparta-updates
#   cd sparta-updates
#   ./fetch-releases.sh          # re-run after each release; idempotent
#   git pull && ./fetch-releases.sh   # to pick up newly released versions
#   # then serve this directory at .../updates/
#
# For a PRIVATE repository, run where `gh` is authenticated, or export
# GITHUB_TOKEN with read access to the releases.

set -euo pipefail
cd "$(dirname "$0")"

shopt -s nullglob
composites=(*/compositeContent.xml)
if [ ${#composites[@]} -eq 0 ]; then
  echo "ERROR: no <year>/compositeContent.xml found -- run this from a gh-pages checkout." >&2
  exit 1
fi

# Resolve OWNER/REPO from the clone's origin remote.
origin="$(git config --get remote.origin.url)"
slug="$(printf '%s' "$origin" | sed -E 's#^(https?://[^/]+/|git@[^:]+:)##; s#\.git$##')"
dl="https://github.com/${slug}/releases/download"

have_gh() { command -v gh >/dev/null 2>&1; }

# download <tag> <asset> <out>
# Release assets on a PUBLIC repo are downloadable anonymously, so plain curl is
# tried first -- this works even if gh happens to be installed but not logged in.
# A token (GITHUB_TOKEN) or an authenticated gh CLI is only needed for PRIVATE
# repositories.
download() {
  local tag="$1" asset="$2" out="$3"
  local auth=()
  [ -n "${GITHUB_TOKEN:-}" ] && auth=(-H "Authorization: Bearer ${GITHUB_TOKEN}")
  if curl -fsSL "${auth[@]}" -o "$out" "${dl}/${tag}/${asset}"; then
    return 0
  fi
  # Fall back to the gh CLI (its own auth) -- needed for private repos.
  if have_gh; then
    gh release download "$tag" --repo "$slug" --pattern "$asset" --output "$out" --clobber
  else
    return 1
  fi
}

new=0 total=0
for comp in "${composites[@]}"; do
  year="${comp%/compositeContent.xml}"
  # Versions this year's composite references: <child location='releases/<v>'/>.
  versions="$(grep -oE "location='releases/[^']+'" "$comp" \
    | sed -E "s#location='releases/##; s#'##" | sort -Vu)"

  for ver in $versions; do
    total=$((total + 1))
    [ -d "$year/releases/$ver" ] && continue

    asset="sparta-updatesite-${ver}.zip"
    tmp="$(mktemp)"
    # The release tag may be either <version> or v<version>; try both.
    if download "$ver" "$asset" "$tmp" 2>/dev/null || download "v$ver" "$asset" "$tmp" 2>/dev/null; then
      :
    else
      echo "  WARN: could not fetch $asset (tried tags '$ver' and 'v$ver') -- skipping." >&2
      rm -f "$tmp"
      continue
    fi

    stage="$year/releases/.stage-$ver"
    rm -rf "$stage" "$year/releases/$ver"
    mkdir -p "$stage"
    unzip -q "$tmp" -d "$stage"
    rm -f "$tmp"

    # Normalize: the archive may hold the repo at its root or in a single subdir.
    if [ -f "$stage/content.jar" ] || [ -f "$stage/content.xml" ]; then
      mv "$stage" "$year/releases/$ver"
    else
      inner="$(find "$stage" -mindepth 1 -maxdepth 1 -type d | head -n1)"
      if [ -z "$inner" ]; then
        echo "ERROR: '$asset' does not look like a p2 repository." >&2
        rm -rf "$stage"
        exit 1
      fi
      mv "$inner" "$year/releases/$ver"
      rm -rf "$stage"
    fi
    echo "Extracted $year/releases/$ver"
    new=$((new + 1))
  done
done

echo "Done: ${new} new, ${total} referenced across $(printf '%s ' "${composites[@]%/compositeContent.xml}")composite(s). Serve this directory at .../updates/."
