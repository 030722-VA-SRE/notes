## Maven Build Lifecycle

When Maven builds your project, it goes through several steps called **phases**. The default maven build lifecycle goes through the following phases:
1. Validate => project is correct and all necessary information is available 
2. Compile => compiles project source code 
3. Test => tests all compiled code 
4. Package => packages all compiled code to WAR/JAR file 
5. Integration => performs all integration tests on WAR/JAR
6. Verify => runs checks on the results of integration tests 
7. Install => installs WAR/JAR to local repository 
8. Deploy => copies final WAR/JAR to the remote repository 

Each phase in turn is composed of plugin goals that are bound to zero or more build phases. A "goal" represents a specific task which contributes to the building or managing of the project.

For more information, see the [Maven documentation](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).

## Using the `mvn` command

To use the Maven CLI (command-line interface), first test that you have Maven installed:
```
mvn --version
```

Now, once you are in your project directory, you can run any phase in the default build lifecycle. Maven will look for the `pom.xml` file and use that to run the phase.

```
cd /path/to/myproject/
mvn package
```

To execute a specific Maven goal, use the `plugin:goal` syntax:

```
mvn dependency:copy-dependencies
```

Multiple phases or goals can be run sequentially. Again, see the Maven documentation for more information.
