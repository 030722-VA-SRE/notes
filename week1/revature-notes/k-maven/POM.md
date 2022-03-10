# POM - Project Object Model 

[Maven](https://maven.apache.org/) is a dependency manager and build automation tool for Java programs. Maven project configuration and dependencies are handled via the Project Object Model, defined in the `pom.xml` file. This file contains information about the project used to build the project, including project dependencies and plugins.

Some other important tags within the `pom.xml` file include:
* `<project>` - this is the root tag of the file
* `<modelVersion>` - defining which version of the page object model to be used
* `<name>` - name of the project
* `<properties>` - project-specific settings
* `<dependencies>` - this is where you put your Java dependencies you want to use. Each one needs a `<dependency>`, which has:
  * `<groupId>` , `<artifactId>`, `<version>` - [project coordinates](./Project-Coordinates.md)
* `<plugins>` - for 3rd party plugins that work with Maven


Here's an example:

```
<project>
  <modelVersion>4.0.0</modelVersion>
 
  <groupId>com.revature.app</groupId>
  <artifactId>my-app</artifactId>
  <version>1</version>
  
  <dependencies>
    <dependency>
      <groupId>org.apache.maven</groupId>
      <artifactId>maven-artifact</artifactId>
      <version>${mavenVersion}</version>
    </dependency>
    <dependency>
      <groupId>org.apache.maven</groupId>
      <artifactId>maven-core</artifactId>
      <version>${mavenVersion}</version>
    </dependency>
  </dependencies>

</project>
```
