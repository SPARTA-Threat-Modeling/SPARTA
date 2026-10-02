# Contributing to SPARTA

Thank you for your interest in contributing to SPARTA.

## Building

* Use **JDK-21** to build (the Tycho build resolves a JavaSE-21 execution environment).
* Use a **recent Maven (>= 3.8)**. Maven `3.6.1` has a known bug in combination with Tycho that leads to strange build errors.
* Build everything with `mvn clean package` from the repository root. See the [README](README.md#building-sparta) for options to skip the (slow) product packaging step.

## Running the tests

Run `mvn verify` from the repository root. This compiles all bundles and standalone modules and executes the unit and plugin (Tycho-surefire) tests.

## Project layout

The repository is a Tycho/plain-Maven hybrid: Eclipse plug-ins live under `bundles/`, `features/`, and `releng/`, while `standalone/` contains plain-Maven jars that run the analysis outside of Eclipse. See the [Project Structure section of the README](README.md#project-structure) for the module-by-module overview.

## Eclipse IDE setup

To work on the plug-ins and models in Eclipse, install the dependencies listed in the [Dependencies section of the README](README.md#dependencies) (EMF/Ecore tooling, Sirius, and Viatra).

## Commit messages

Commit messages follow the [Conventional Commits](https://www.conventionalcommits.org/) convention, e.g. `fix(core): ...`, `feat(analysis): ...`, `docs: ...`. Keep the subject imperative and concise; use the body to explain the why.

## License

SPARTA is licensed under the [Eclipse Public License 2.0](LICENSE) (EPL-2.0). Every Java source file must carry the EPL license header (template in `EPL-header.txt`).

## Reporting issues

Please report bugs and feature requests via the [GitHub issue tracker](https://github.com/SPARTA-Threat-Modeling/SPARTA/issues). For security vulnerabilities, see [SECURITY.md](SECURITY.md) instead.
