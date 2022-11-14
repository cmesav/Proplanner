# **Wappi web Automation**

## Pre requirements 📋

- Java version 1.8
- Gradle
- Cucumber for Java
- Gherkin Plugin

## Installation ⚙️

- To clone this repository locally
- Import the project from Eclipse or IntelliJ IDE under the structure of an existing Gradle project.
- Configure JRE System Library with JavaSE-1.8.


## Building 🛠

Automation is developed with:

- BDD - Development strategy
- Screenplay pattern - Design pattern that applies SOLID principles
- Gradle - Project and Dependency manager
- Selenium Web Driver - Tool to automate actions in web browsers
- Cucumber - Framework to automate BDD tests
- Serenity BDD - Framework, Open source library for report generation
- Gherkin - Business-readable domain specific language (DSL)

## Programming convention

The following writing styles are used in automations:

- Variables and functions: Lower Camel Case. Example: `nomenclatureExample`.
- Class names: PascalCase or Upper Camel Case. Example: `NomenclatureExample`.
- Feature names: Snake Case. Example: `nomenclature_example`.

## Command for execution ▶️

- The project can be executed from the console with the following command:
  ```gradle clean test```.
- The Serenity report will be generated in the folder ``/target/site/serenity/`` located in the root folder of the
  project.

## Authors ✒

* **Cristian Alberto Mesa Vergara** - [mesa.cristian@gmail.com]