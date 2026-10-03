# Bundled example projects

Zipped Eclipse projects installed by the example wizards in `plugin.xml`
(File > New > Example... > SPARTA, and the welcome screen). Each zip holds the
project contents at its root (`.project`, `representations.aird`, `*.sparta`).
They are archives rather than folders because the bundle is jarred, and EMF's
`ExampleInstallerWizard` can extract a single file from a jarred plug-in but not
a directory tree.

| Zip | Source |
| --- | --- |
| `contoso.zip`, `socialnetwork.zip`, `webrtc.zip` | [example-cases](https://github.com/SPARTA-Threat-Modeling/example-cases) @ `203813d7`, with two clean-ups in `representations.aird` (see below) |
| `sparta-tutorial.zip` | Starter project for the guided-tutorial cheat sheet (`cheatsheets/first-model.xml`): a minimal `representations.aird` with the DataFlowDiagram viewpoint enabled, `stride-per-interaction - Shostack.sparta` (identical to [catalogs](https://github.com/SPARTA-Threat-Modeling/catalogs)) and `SecurityPatternCatalog.sparta` (the copy from the WebRTC example) |

Clean-ups applied to the example-cases `representations.aird` files:

* removed the `stride-per-interaction - MSTMT.sparta` semantic resource (contoso, webrtc). The file is not part of the projects and nothing references it.
* removed the empty view on the no-longer-existing `MyViewpoint` viewpoint, and its entry in `selectedViews` (all three).

To refresh an example, copy the project folder from example-cases, reapply the
clean-ups, and zip its contents (not the folder itself), for example
`cd contoso && zip -r ../contoso.zip .project *`.
