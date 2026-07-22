# SPARTA update site (deployment branch)

This `gh-pages` branch holds the **per-year composite update-site metadata** —
built and committed by CI on every release — plus a small `fetch-releases.sh`
helper. It does **not** hold any binaries: the per-version p2 repositories are
published as `sparta-updatesite-<version>.zip` assets on the GitHub Releases.

There is one composite per release line (major version == year), e.g. `2026/`,
`2027/`. Serve the checkout at `.../updates/` so each line is reachable at
`.../updates/<year>/` — the URL baked into that year's features.

## Deploy / update the site

On the web server:

```sh
# first time
git clone --branch gh-pages --single-branch <repo-url> sparta-updates
cd sparta-updates
./fetch-releases.sh

# after a new release
git pull               # get the updated composite (CI added the new child)
./fetch-releases.sh    # download + extract only the newly referenced version
```

Then point any static web server at this directory, served at `.../updates/`.
Users add `.../updates/<year>/` in Eclipse via *Help → Install New Software*; a
single version is also consumable directly at `.../updates/<year>/releases/<version>/`.

## How it works

- **CI owns the composites.** On each release the pipeline regenerates
  `<year>/compositeContent.xml` / `<year>/compositeArtifacts.xml` (one `<child>`
  per released version in that line) and commits them here. The server never
  builds this metadata.
- **`fetch-releases.sh` only fetches binaries.** For each `<year>/` composite it
  reads the `<child location='releases/<version>'/>` entries and, for every
  `<year>/releases/<version>/` not yet present, downloads that release's
  `sparta-updatesite-<version>.zip` and extracts it in place. It uses only `curl`
  (or `gh`) and `unzip` — no p2/Maven/Tycho — and is idempotent.

The `releases/` folders are git-ignored (see `.gitignore`); this branch never
stores binaries. For a **public** repository no authentication is needed — the
release assets download anonymously. Only for a **private** repository do you
need to run where `gh` is authenticated or export `GITHUB_TOKEN`.
