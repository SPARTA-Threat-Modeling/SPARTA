# SPARTA Threat Modeling Tool

SPARTA (Security and Privacy Analysis through Risk-driven Threat Assessment) enables the creation of extended DFDs with security and privacy solutions (countermeasures) to include security and privacy information into the DFD model and support the elicitation of security and privacy threats that take this information into account as part of the risk analysis.
This is a different approach compared to some other tools where threats that are mitigated would disappear.
SPARTA will always elicit all the threats, but will recalculate the risk to take those countermeasures into account.

The SPARTA project consists of the following parts:
 
* A standalone threat modeling tool that you can you can run locally. You can download this from the main [SPARTA website](https://sparta.distrinet-research.be/downloads/).
* Eclipse-plugins that allow you to integrate it's functionality in other eclipse-based tools. For this you can use the [eclipse update site](https://downloads.sparta.distrinet-research.be/updates/2026/). Update sites are organised per release line (by year): the URL is `https://downloads.sparta.distrinet-research.be/updates/<year>/` (e.g. `.../updates/2026/`), so you can pick the line that matches your installation. A specific version is also available directly at `.../updates/<year>/releases/<version>/`.
* Standalone libraries and runnable jars, so you can directly run the analysis on .sparta models. These are available from the [maven repository](https://maven.sparta.distrinet-research.be/).



## Project Structure

The root directory contains the following structure.

* *be.kuleuven.cs.distrinet.sparta.root* root project with the configuration
* **bundles:** the individual SPARTA plugins
  * *be.kuleuven.cs.distrinet.sparta.analysis* the main analysis view and threat analysis engine
  * *be.kuleuven.cs.distrinet.sparta.design* the graphical DFD editor
  * *be.kuleuven.cs.distrinet.sparta.queries* the threat elicitation patterns
  * *be.kuleuven.cs.distrinet.sparta.rcp* the SPARTA eclipse product customization, perspectives, etc.
  * *be.kuleuven.cs.distrinet.sparta.spartamodel* the sparta meta-model used to generate the edit/editor
  * *be.kuleuven.cs.distrinet.sparta.spartamodel.edit*
  * *be.kuleuven.cs.distrinet.sparta.spartamodel.editor*
  * *be.kuleuven.cs.distrinet.sparta.spartamodel.tests*
* **features:** the SPARTA eclipse features, currently only one (can be used later to package jre lib in product)
  * *be.kuleuven.cs.distrinet.sparta.feature* sparta feature combining all the previous plugins
  * *be.kuleuven.cs.distrinet.sparta.graphicalmodeling.feature* sparta feature with the graphical editor plugin
  * *be.kuleuven.cs.distrinet.sparta.modeling.feature* sparta feature combining the modeling plugins
  * *be.kuleuven.cs.distrinet.sparta.threatanalysis.feature* sparta feature combining the threat analysis plugins
* **releng:** release engineering plugins, the product, updatesite, and tycho configuration
  * *be.kuleuven.cs.distrinet.sparta.product* standalone product configuration
  * *be.kuleuven.cs.distrinet.sparta.update* updatesite
* **standalone** standalone jars of the spartaplugins to run outside of eclipse


## Dependencies

Build with JDK-21.
Last tested in Eclipse 2025-06 RCP/RAP.
For editing the models you can install the following dependencies in your eclipse:

 * Modeling > Ecore Diagram Editor (SDK) + EMF - Eclipse Modeling Framework SDK (from eclipse update site)
 * Sirius (7.x): *installed from market place*
 * Viatra (2.7.x): *installed from viatra repository url*
 * You may want to include the *Ecore Diagram Editor (SDK)* from the generic eclipse repository to enable the graphical meta-model editor.


## Building SPARTA

SPARTA can be built as a packaged eclipse product.
The entire project can be build with *maven*[^mvn] using the command: `mvn clean package`.
This will:

[^mvn]: Make sure to use a recent version of maven. The `3.6.1` has a bug in combination with *tycho* that leads to strange build errors.

* clean all target directories
* generate the VIATRA pattern java code
* compile all plugins and features
* generate the update site
* package the eclipse product

To reduce the build time, the product packaging step can be excluded by running `mvn -pl '!releng/be.kuleuven.cs.distrinet.sparta.product' clean package` or `mvn -pl "!releng/be.kuleuven.cs.distrinet.sparta.product" clean package` on windows.

The results of the build can be found in:

* **Updatesite:** in `releng/be.kuleuven.cs.distrinet.sparta.update`
* **SPARTA product:**  in `releng/be.kuleuven.cs.distrinet.sparta.product`

