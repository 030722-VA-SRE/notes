### First Java Program - HelloWorld
Let's walk through a simple HelloWorld program. You must have a JDK intalled in order to do this.
1. Open up your command-line terminal application
2. Check that you have a JDK installed:
```bash
javac -version
# if you get something like "command not found" on your terminal, you don't have the JDK installed
# if you get a valid java version (e.g javac 1.8.0_211), the jdk is installed properly

```
3. Create a directory, move to it, and create a file called `HelloWorld.java`
```bash
mkdir java-practice
cd java-practice
touch HelloWorld.java
```
Now open this file with a simple text editor program and write the HelloWorld application.
```java
public class HelloWorld {

  public static void main(String[] args) {
    System.out.println("Hello, world!");
  }
}
```

4. Now that the source code is written, we can compile it into bytecode using the compiler (`javac`):
```bash
javac HelloWorld.java
# If this command executes without any errors, your code has compiled successfully
```
You should now see a `HelloWorld.class` file in your directory - this contains the compiled bytecode of the program. If you open it up in a text editor, it will appear as gibberish because the bytecode is not human-readable, it is merely instructions that the JVM can understand and run.
    
5. Finally we can run the compiled bytecode using the `java` command
```bash
java HelloWorld
# Hello World!
```
This command loads and executes the `HelloWorld.class` file. Note that we **do not** include the `.class` extension when using the `java` command.
