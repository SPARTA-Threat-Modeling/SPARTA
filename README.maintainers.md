# SPARTA Threat Modeling Tool

## Updating versions

```
mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=major.minor.service.qualifier
```

## Updating license headers

To check header files: `mvn license:check`

To add headers: `mvn license:format`

## Release pipelines

Releases are tag-driven on both platforms. A git tag shaped like a version
(`2026.1.0`, `v2026.1.0`, optional `.qualifier`) triggers the release job in
`.github/workflows/release.yml` (GitHub) and the `release` job in
`.gitlab-ci.yml` (GitLab). Non-version tags don't match the gate and build
nothing. Each release job:

1. rewrites all versions from the tag (`tycho-versions:set-version`),
2. runs `mvn deploy` — a single pass that tests, packages the whole reactor, and
   publishes the **library set** (bundle jars, features, `standalone/*` jars and
   the parent poms) to that platform's Maven registry. The `releng` modules
   (`...product`, `...update`) skip the deploy plugin in their poms, so the p2
   update site and product zip are **never** pushed to a Maven registry.

Each platform publishes to its own registry (GitHub Packages / the GitLab
project registry); downstream consumers can use either.

## Update site (p2) — how it's published and deployed

The p2 update site is deliberately kept out of the Maven registries. It is
organized **per release line (major version == year)** — one composite per year,
served at `https://downloads.sparta.distrinet-research.be/updates/<year>/`, which
is the URL baked into that year's `feature.xml` `<update>` entries and the
`.product` repository. An installed build therefore only sees updates from its
own line.

Two parts are separated by responsibility:

- **Composite metadata → committed by CI to `gh-pages`.** On each release the
  pipeline regenerates `<year>/compositeContent.xml` / `<year>/compositeArtifacts.xml`
  (one `<child>` per released version in that line) and commits them, together
  with `fetch-releases.sh` + docs (sources under `releng/updatesite/`). No
  binaries.
- **Binaries → GitHub Release assets.** The `be.kuleuven.cs.distrinet.sparta.update`
  module produces the per-version p2 repository; CI attaches it to the release as
  `sparta-updatesite-<version>.zip` (a self-contained p2 repo).

### Deploying / updating the served update site

On the web server, clone the `gh-pages` branch (you get the composites) and run
`fetch-releases.sh` to download + extract the referenced versions next to them.
Re-run after each release (idempotent — only missing versions are fetched):

```sh
git clone --branch gh-pages --single-branch <repo-url> sparta-updates
cd sparta-updates
./fetch-releases.sh         # download + extract each <year>/releases/<version>
git pull && ./fetch-releases.sh   # after a new release
# serve this directory at .../updates/  (so .../updates/2026/ is the 2026 line)
```

`fetch-releases.sh` does **not** build any metadata — CI already committed the
composites. For each `<year>/` it reads the `<child location='releases/<version>'/>`
entries from that composite and, for each folder not yet present, downloads that
release's `sparta-updatesite-<version>.zip` and extracts it. It needs only `curl`
(or `gh`) and `unzip`. The `releases/` folders are git-ignored, so the branch
never accumulates binaries. For a private repo, run where `gh` is authenticated
or export `GITHUB_TOKEN`.

Users add `…/updates/<year>/` in *Help → Install New Software*; a single version
is also consumable directly at `…/updates/<year>/releases/<version>/`.

**URLs stay in sync automatically.** The release build derives the year from the
tag and, right after `tycho-versions:set-version`, rewrites the SPARTA
`/updates/<year>` URLs in the four `feature.xml` files, the `.product` repository
and `index.html` to match. So a `2027.x` tag ships features/product advertising
`/updates/2027` without any manual edit — the committed value only tracks the
current development line.

### One-off retrieval without the script

```
# a specific published version:
gh release download <tag> --pattern 'sparta-updatesite-*.zip'   # then unzip

# or build locally:
mvn -pl releng/be.kuleuven.cs.distrinet.sparta.update -am package
# exploded p2 repo: releng/be.kuleuven.cs.distrinet.sparta.update/target/repository/
# zipped p2 repo:   releng/be.kuleuven.cs.distrinet.sparta.update/target/*.zip
```

The unzipped archive is a self-contained p2 repository (directory with
`artifacts.jar`/`content.jar`, `plugins/`, `features/`) — copy it to any static
host and point Eclipse at that URL.
