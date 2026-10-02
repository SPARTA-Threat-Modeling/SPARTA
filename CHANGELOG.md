# Changelog

All notable changes to this project are documented in this file. The format is
based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/); versions
follow the year-based release lines (`<year>.<minor>.<patch>`).

Release notes are generated from the [Conventional Commits](https://www.conventionalcommits.org/)
history with [git-cliff](https://git-cliff.org). Sections for releases before
2026.2.0 were written by hand from the earlier development history.

## [2026.2.0] - 2026-07-21

### Added

- Automated builds of the Maven artifacts, update sites and product, with GitHub releases including cross-platform product assets (4716107, 75460e5, b73ad50)
- Test plugins for the core engine, analysis and io, included in the Maven build (02ffb41, 351950f, 95ebab2, 24b0a71, 36029e0)

### Changed

- **Breaking:** Restructured the standalone projects: third-party dependencies are centralised in the standalone parent (the `standalone-dependencies` project is removed), the CLI returns non-zero exit codes, all exporters write UTF-8, server submissions have timeouts, and the ambiguous two-letter CLI short options are removed (e2b5c96)
- Engine refactoring to use an engine-specific loop configuration (586b455)
- Plugin packaging, update site and versioning fixes, and uniform Java versions across the build (812a700, eb05dc0)
- Updated VIATRA plugin repository and project repository URLs (68a0618, fc22cfe)

### Fixed

- Add null guards to fix CLI export errors for threat catalogs that have certain values missing (851a7f8)
- Engine fix for legacy interaction-based patterns (a35db52)
- Introduce several small fixes in the core engine plugin (fd9b7b8)
- Analysis plugin engine dispose handling (1b3b01f)
- Small fixes, improvements and refactorings in the io libraries (d7e3fbd)
- Small RCP fixes and optimizations (aae3c00)
- Suppress inject warnings on dependencies (abf8a91)
- Small bugfixes and refactoring in the core plugin (de24789)
- A number of small fixes and optimizations in the analysis plugin (9c420dd)
- ReportWriter propagates IO exceptions rather than continuing a failed export (40a95df)

### Documentation

- Maintainers readme updates on versions (5db5908)

## [2026.1.0] - 2026-04-20

### Changed

- `RoleBinding.bindsTo` multiplicity changed to `0..*`, so a solution's role binding can bind to any number of DFD elements (830938d)

## [2026.0.0] - 2026-03-03

### Added

- SPARTA is released as open source under the Eclipse Public License 2.0, on GitHub (https://github.com/SPARTA-Threat-Modeling)
- Report export from the threat analysis view: generates a LaTeX report from templates, including TikZ data flow diagram styles and a Tufte-book layout
- Risk calculation now includes estimates defined on data types, and the data types Sirius diagram was updated to match
- The CLI handles custom threat patterns, with number formatting for pattern-based threats
- Conditional styling in the diagram editor layers

### Changed

- `threatened` is renamed to `location` in the VQL queries too; models that still use `threatened` keep working
- Exported threat descriptions now have their parameters filled in
- Target platform moved to Eclipse 2025-06 with updated product dependencies; Guice was upgraded and `javax.inject` replaced by `jakarta.inject`
- CI builds on Java 21 (Temurin)

### Fixed

- NullPointerException in the CSV export
- Threats and threat types mixed up in the analysis view
- Engine ResourceSet handling, also used by the CLI

### Removed

- Bundled example models in the source repo; these are in a separate repository.

## [2025.0.0] - 2025-08-22

### Added

- Pattern-based threat analysis view that lists threats derived from threat pattern catalogs
- The threat viewer shows the threat type ancestor, the specific threat name and an extended description, and can list threats per element
- Resizable columns in the threat view
- Threat type IDs, and estimates that can be set per threat type ID

### Changed

- Built on Eclipse 2024-12 with Java 11; CI moved to Maven 3.9 on Temurin 17
- "Threat category" is renamed to "threat group", and the CSV export headers changed to match
- A threat's `threatened` element is renamed to `location`
- Source files now carry EPL-2.0 license and copyright headers
- The configuration project was merged into the root Maven project, and plugin dependency versions were updated
- Example models and diagrams updated for 2025

### Fixed

- Threat pattern parsing
- The CSV export used the wrong loaded resource
- Sirius `.aird` version problem, fixed by removing the ELK reference

## [2022.1.x] - 2023 (not released)

The version was set to 2023.0.0 in January 2023 but reset to 2022.1.1-SNAPSHOT
in July 2023; no 2023 release was made. Along the way the line went through
2022.0.1, 2022.1.0 and 2022.1.1.

### Added

- First support for threat pattern catalogs, with a `ThreatTypeCatalog` and `ThreatPattern` model and a pattern parser
- Generic model element annotations (key/value) for custom user extensions
- The threat export includes the potential risk

### Changed

- Fewer choices offered for a countermeasure's subject and scope
- Build moved to Eclipse 2022-12 and Tycho 2.7.4
- The threat analysis no longer writes `threats.csv` automatically on every analysis
- Contoso example model updated

### Fixed

- Update site URL
- `containerDiff` bug in the DFD queries
- Bug in the CLI CSV export

## [2022.0.0] - 2022-10-25

### Added

- Data type metamodel (`DataModel`, `DataType`, `TransformedData`); role bindings were reworked into assets, and `DFDModelElement` was renamed to `ModelElement`
- Threat CSV export, later extended with the match type and quoted entries
- YAML-to-EMF model converter for the standalone tools
- Editor improvements: create a security DFD from the context menu, label editing, moving elements between containers, solution instantiation, and creating and reconnecting data flow specifications
- Attacker estimate names and estimate text for `PersonalDataType` and `DataSubjectType` shown in the editor
- Separate standalone `sparta-model` library
- `sparta-ci` sends the XML model with each submission, and `sparta-cli` has a separate model-reading method
- Self-contained update site with an index page, separate features for modeling and analysis, a bundled JRE in the product, and license files

### Changed

- Threat queries: the threat specification is now optional, and threat types and patterns are enabled or disabled through the catalog tree, which reduces duplication in the threat type catalog
- The privacy DFD model was merged into `spartamodel`, and the privacy queries into `sparta.queries`
- The analysis plugin now uses the standalone core library, repackaged as Eclipse plugins
- Model resource renamed to `spartaresource`; the resource factory now uses UUIDs
- Product moved to Eclipse 2022-03, then 2021-12, and finally back to 2020-12 because of Eclipse Collections classloading problems; VIATRA now runs standalone with default query backends
- Updated example models: WebRTC, social network, SecureDrop and Contoso
- Updated branding and icons, and changed the default workspace directory

### Removed

- The old diagram view (data store visualization updated)

### Fixed

- `NoSuchElementException` when computing the maximum SLE for an empty threat list
- Data-flow-through pattern broken by the mitigation patterns
- BetaPERT sampling where the minimum was not set, plus fixes to the threat aggregation analysis

## [2.0.0] - 2021-01-20

### Added

- Standalone SPARTA CLI, split into `sparta-cli`, `sparta-core` and `sparta-export`, with text, XLSX and JSON threat output, statistics, and a code-quality export
- `sparta-ci` module for running SPARTA in CI pipelines
- Core Eclipse plugin that packages the standalone libraries
- Privacy DFD modeling and privacy risk analysis: DFD–DPM correspondences, attacker profiles and queries, risk aggregation and heatmaps, merged into the main analysis project
- Threat aggregation analysis as a separate project, with extended analysis methods
- SDLC-book threat catalog with threat tree patterns
- Optional API documentation generation (`-Djavadoc.skip=false`)
- SPARTA perspective icon, a signed update site, and deployment to the GitLab Maven registry

### Changed

- VIATRA patterns are loaded directly instead of being discovered at runtime, and the editor listens for more model changes
- VIATRA upgraded from 2.4.0 to 2.5.0, now using the local search backend
- Build moved to Java 11, Eclipse 2020-12 (from 2020-06) and Tycho 2.2.0
- Updated example models, including WebRTC and the data store / security solution visualization

## [1.0.0] - 2020-05-26

Covers the initial development, from the first commit in March 2017 up to the
first version built with Maven/Tycho.

### Added

- Data flow diagram (DFD) Ecore metamodel and Sirius diagram editor (viewpoint, representations), with a security view layer and nested trust boundaries
- Hierarchical DFD decomposition views, with validation rules for DFD soundness, decomposition completeness and trust boundary consistency
- Security metamodel extensions: threats, security objectives, patterns/solutions with roles and role bindings, countermeasures, assets, a threat type tree, and composite threat trees with conditions (including imported conditions)
- VIATRA query-based threat elicitation: VQL patterns detect threats on DFD elements and on flows (including flows crossing trust boundaries), and countermeasures' protect relations determine the mitigation status
- Threat catalogs and specifications: a STRIDE specification based on Shostack, a Microsoft Threat Modeling Tool (MSTMT) specification, a security pattern catalog, and a LINDDUN-based privacy threat specification
- Threat analysis Eclipse view that loads VQL patterns dynamically and combines their matches, with a threat counter that updates automatically and a threat layer in the diagram bound to the pattern matches
- Quantitative risk analysis based on the Beta-PERT distribution and estimates in the model: confidence ranges, configurable attacker types (contact frequency, probability of action), TEF/LEF/SLE figures, overall risk statistics, coloured risk labels and threat sorting
- Example models: Contoso, a WebRTC system with countermeasures, and a social network privacy model
- Eclipse feature and update site
- Automated Maven/Tycho build with VIATRA query code generated during the build, a SPARTA product definition with icons, and examples moved to `examples/`

### Changed

- Reworked the metamodel for risk analysis (estimates, attacker information), simplified roles/role bindings and security-solution naming, regenerated the EMF editor code with UI improvements, and added UUIDs to XMI files

### Removed

- The communication pattern catalog, the trust boundary line element and the dataflow specialisation were dropped from the metamodel

### Fixed

- A null pointer in the threat analysis view, metamodel references in the odesign, and errors in the MSTMT and repudiation threat specifications
