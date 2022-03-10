## [Maven](https://maven.apache.org/) Review

Maven is a dependency manager and build automation tool for java projects.

Project Object Model (POM):

- Handles project configuration and dependencies which are defined in the **pom.xml** file. Here is an example pom.xml file.
```HTML
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

Maven Lifecycle:

- When Maven builds your project, it goes through several steps called phases. The default maven lifecycle is:

1. Validate => project is correct and all necessary information is available
2. Compile => compiles project source code
3. Test => tests all compiled code
4. Package => packages all compiled code to WAR/JAR file
5. Integration => performs all integration tests on WAR/JAR
6. Verify => runs checks on the results of integration tests
7. Install => installs WAR/JAR to local repository
8. Deploy => copies final WAR/JAR to the remote repositor
