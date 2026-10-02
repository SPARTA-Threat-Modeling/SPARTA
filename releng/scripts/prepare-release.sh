#!/usr/bin/env bash
#
# prepare-release.sh <tag-or-version>
#
# Shared release preparation used by BOTH release pipelines (GitHub Actions
# .github/workflows/release.yml and the GitLab .gitlab-ci.yml `release` job),
# so the version/URL rewriting logic exists exactly once.
#
# The git tag is the single source of truth for the version. Given the tag
# (an optional leading "v" is stripped), this script:
#   1. rewrites every pom, MANIFEST.MF, feature.xml and the .product to the
#      tag version via tycho-versions:set-version, and
#   2. keeps the per-year update-site URLs in sync with the release line
#      (major version == year), so an e.g. 2027 build advertises
#      .../updates/2027 rather than a stale year. Only the SPARTA
#      /updates/<year> path is touched (the legacy /updatesite/2025 site is a
#      different path and is left alone).
#
# MAVEN_CLI_OPTS is taken from the environment (both pipelines define it);
# it is intentionally unquoted below so its options split into words.
set -euo pipefail

if [ "$#" -ne 1 ] || [ -z "$1" ]; then
  echo "usage: $0 <tag-or-version>" >&2
  exit 2
fi

VERSION="${1#v}"
YEAR="${VERSION%%.*}"
echo "Preparing release version ${VERSION} (update line ${YEAR}) from '${1}'"

# shellcheck disable=SC2086
mvn ${MAVEN_CLI_OPTS:-} tycho-versions:set-version -DnewVersion="${VERSION}"

sed -i -E "s#(downloads\.sparta\.distrinet-research\.be/updates/)[0-9]+#\1${YEAR}#g" \
  features/*/feature.xml \
  releng/be.kuleuven.cs.distrinet.sparta.product/*.product \
  releng/be.kuleuven.cs.distrinet.sparta.update/src/main/resources/index.html
