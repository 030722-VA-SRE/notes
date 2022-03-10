# Java
Java is an object-oriented programming language and a platform developed by Sun Microsystems (eaten by Oracle). Using the principle of **WORA** (Write Once, Run Anywhere), a Java application can be compiled and executed on any platform supported by Java. Flexible, popular, and well-supported, Java has helps developers write scalable client-server web applications, desktop and mobile applications, and frameworks and libraries.

## Features
- **Platform independence** The compiler converts source code to bytecode, then the JVM executes that bytecode. While each operating system has their own JVM implementation, so every JVM can execute bytecode regardless of origin of said code.

- **Clear, verbose syntax** Java has C-like syntax like C++ and C#, many syntax elements of the language are readable and widely used in programming. The Java API (Application Programming Interface) is also written using verbose, descriptive naming conventions making it simple to parse large code bases.

- **Multi-paradigm** While Java is object-oriented, it supports multiple paradigms such as imperative, generic, concurrent, and functional.

- **Garbage collection** The JVM performs automatic memory deallocation of unused objects at runtime. Programs are written without the need for complex memory management.

- **Multithreading** Java supports multithreading at both language and the standard library levels. It allows concurrent and parallel execution of several parts of a Java program.

## Programming and Compiling
Most Java applications only require the **JRE** (Java Runtime Environment). But to write and compile you need the **JDK** (Java Development Kit). While the JRE provides Java's standard libraries and exceptions as well as a JVM, the JDK provides all the above as well as *javac*, the compiler. Java source code is written in text files labeled with *.java* extension. It is then compiled into bytecode in *.class* files by *javac*. Then the bytecode is executed by the JVM, which translates the Java commands into low-level instructions to the operating system.

Since Java 6, all Java programs not run inside a container (such as a Servlet Web Container) start and end with the main method. The class containing the main method can have any name, but the method itself should always be named *main*

```java
class Example {
    public static void main(String[] args) {
        System.out.println("Num args:" + args.length);
    }
}
```

- *public* is a Java access modifier keyword that means the `main` method can be accessed from any method during the program's execution.
- *static* is a Java keyword that means the method can be invoked without creating an instance of the class that contains it, making it a global method.
- *void* is a Java return type keyword that means the method doesn't return any values of any data type.
- *args* is a Java variable of type String array which means the method can take command line arguments as an array of Strings

We can compile this code into a *.class* file of the same name:
>javac Example.java

And to run the resulting `Example.class` file:
>java Example

The `java` and `javac` commands require the full directory path or class path to any source code or binary file respectively. If you have a package `com.demo` in the first line of Example, then you would nest the java file into a `com/demo/` directory and then run:
>javac com/demo/Example.java 

>java com.demo.Example

From here we can add packages and imports, expanding the application into a set of interacting objects. By default, the *javac* compiler implicitly imports several base packages from the standard library. the `-help` flag can display available options. For example, the following will compile using UTF-8 encoding while conforming to Java 1.8 features:
>javac -encoding UTF-8 -source 8 -target 8 Example.java

## Object-Oriented Programming
Although Java accommodates several paradigms, OOP is the foundation for most applications. In OOP, a program is organized into objects encapsulating related fields (representing its *state*) and methods (usually to control that state or perform related functions). When defining objects, Java reserves the keyword *class* (not to be confused with the *.class* file extension) which serves as their blueprint. An object in Java represents an instance in memory of a class, and also every class implicitly inherits from the *Object* superclass which provides useful convenience methods such as *equals()* and *toString()*. Java popularized several 'Pillars' of OOP design theory. While the numbers vary between OOP languages, Java focuses on four:

- **Abstraction** By simplifying objects to a set of useful features, we hide irrelevant details, reduce complexity, and increase efficiency. Abstraction is important at all levels of software and computer engineering, but essential to designing useful objects. Complicated real-world objects are reduced to simple representations.

- **Encapsulation** Objects should group together related variables and functions and be in complete control over them. So the state of an object should only change, if ever, through the object itself. Also known as data hiding, because the object has sole responsibility for its fields, and no outside object or function should interfere.

- **Inheritance** Code reuse is an important principle of programming (DRY - Don't Repeat Yourself), and new classes can reuse code from existing ones. This establishes a superclass-subclass (or parent-child) relationship where the derived classes inherit (and sometimes change) fields and methods from its parent.

- **Polymorphism** With inheritance, an object of a derived class can be referenced as instances of its parent class. This provides flexibility when invoking inherited methods with varying implementations in derived classes.

## Variables
A value is stored and identified in memory by a variable. Variables have a name that makes it possible to access the value, and a type that defines what sort of value it stores.
```java
int variableName = 64;
String txtVar = "Hello World";
```

## Primitive data types
Java handles two kinds of datatypes: primitives and references. Primitives are variables that store simple values. There are eight in Java.
- Integer types: **byte**, **short**, **int**, and **long** (42)  
- Floating-point types: **float**, and **double** (3.1415)  
- Logical types: **boolean** (true)  
- Character type: **char** ('x')

## Reference types
Reference types store the memory address location of more complex data types in the heap. Reference types include:
- Classes
- Interfaces
- Enums
- Arrays

## Naming variables
- Case sensitivity
- Can only use letters, numbers, and *$* or *_* characters
- Cannot begin with a number
- Cannot be a reserved Java keyword

## Scopes of a variable
A variable's reference will only exist within the context of its declared scope, which is based on the location of its declaration.

- **Static** or class scoped variables are visible to all instances of a related class.
- **Instance** or instance scoped variables are visible to only that object instance.
- **Local** or method scoped variables are visible only within a method.
- **Block** or loop scoped variables are visible only within a block statement.

Be aware of *shadowing*: when two variables in different scopes share names.

## Methods
Methods accept a list of arguments known as *parameters* and return some value. They are used to implement repeatable, consistent actions on variable input, much like math functions.
```java
public int myMethod(int a, int b);
public int myMethod(int a);
```

## Constructors
Classes not only define object fields and methods, but how it should be instantiated through special methods called constructors. Constructors must have no return type and share the same name as its class. Java will automatically give you a *noargs* constructor. However, if you define any constructor, you will lose the automatically given constructor.

While a constructor may be *private*, used for singletons, it may not be *final*, *static*, or *abstract*.

## Access modifiers
- **private** - accessible only within the context of that class
- **package-private/default** - accessible within the context of a package, has no associated keyword so is set when no modifier is used
- **protected** - accessible to the package, but also to derived child classes outside of the package
- **public** - accessible anywhere

Classes should only be public or default. There are no cascading access levels, and unspecified fields will be default. Subclasses can only change inherited fields to be less restrictive.

## Arrays
### Declaration
Java Arrays are special reference types that store similarly typed data iteratively. A pair of brackets define an array of some data type, and can be written anywhere after the type:
```java
// One-Dimensional Arrays
int[] arrayOne;
int []arrayTwo;
int arrayThree[];

// Two-Dimensional Arrays
int[][] 2DArrayOne;
int 2DArrayTwo[][];
int []2DArrayThree[];
```

### Definition
While Java does not allow direct memory access to its arrays like other languages, they are still of fixed size once defined by the `new` keyword or by an array literal.
```java
// One-Dimensional Arrays
int[] instancedArray = new int[3];
int[] literalArray = {1, 2, 3};

// Two-Dimensional Arrays
int[][] instanced2DArray = new int[3][4];
int[][] literal2DArray = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
```

### Iteration
Java for loops can iterate through arrays like most other languages:
```java
// One-Dimensional Arrays
for (int i = 0; i < arrayOne.length; i++) {
    System.out.print(arrayOne[i]);
}

// Two-Dimensional Arrays
for (int i = 0; i < 2DArrayOne.length; i++) {
    for (int j  =0; j < 2DArrayOne[i].length; j++) {
        System.out.print(2DArrayOne[i][j]);
    }
}

// Foreach loops
for (int i : arrayOne) {
    System.out.print(i);
}
```

### Manipulation
The `java.util.Arrays` class provides various methods for manipulating arrays.

```java
int[] messyArray = {234, 5346, 3, 64};
Arrays.sort(messyArray);
System.out.println(Arrays.toString(messyArray));
```

### Varargs
Varargs is a special parameter that can accept multiple arguments of the same type into a dynamically constructed array, and denoted by an ellipsis (...) instead of brackets. A varargs parameter must be the last or only parameter in a method signature. 
```java
varArgMethod("m", 1, 2, 5, 35, 346, 345, 4634);

...

public static void varArgDemo(String m, int... intArgs) {
    for (int i : intArgs) {
        System.out.print(i);
    }
}
```

## Exception Handling
When an something wrong occurs during execution, the current stack frame will throw an exception. If the exception is not handled, or thrown up the stack to be handled elsewhere, the program will crash. Good exception handling helps a program continue execution. Common issues which can throw exceptions involve stack or heap memory overflow, an array iterating out of bounds, or an interrupted stream or thread.

### Hierarchy
Exception and error objects extend Throwable and are either checked or unchecked.
* Throwable
    * Exception (checked)
        * RuntimeException (unchecked)
    * Error

Runtime and unchecked exceptions refer to the same thing. We can often use them interchangeably. 

Checked Exceptions are compile-time issues that must be handled or thrown before the compiler can build, such as `IOException`. Unchecked Exceptions occur at runtime, so the compiler cannot predict them and does not force they be handled. Most unchecked exceptions extend RuntimeException, such as `NullPointerException`. Errors are serious issues and should not be handled, such as `StackOverflowError`.

### `throws`
The `throws` keyword re-throws an exception up the stack to the method that called the throwing method. If the exception is continually thrown and never handled, the compiler will be satisfied in the case of checked exceptions but any issues will still break the program.
```java
public void methodThatThrows() throws IOException {
    // throw (singular) will throw a new exception every time.
    throw new IOException();
}

public void methodThatCalls() {
    methodThatThrows(); // IOException must now be handled here, or methodThatCalls() must use throws as well
}
```

### `try`-`catch`
The most basic form of exception handling is the `try`-`catch`:
```java
public void methodThatThrows() throws IOException {
    try {
        throw new IOException();
    } catch (IOException exception) {
        // Do something with the exception
        logger.warn("IOException thrown");
    }
}
```

A `try` block must be followed by at least one `catch` (or `finally`) block, but there can be any number of `catch` blocks for specific (or broad) exceptions. `catch` blocks must be ordered from most specific to least specific Exception objects else later catch blocks catching subclasses of exceptions caught in catch blocks above it will become unreachable code.

Multiple exceptions can also be handled in one catch block:
```java
public void methodThatThrows() throws IOException {
    try {
        throw new IOException();
    } catch (IOException | ServletException e) {
        // Do something with the exception
        logger.warn("IOException thrown");
    }
}
```

### `finally`
Try blocks can be followed by one `finally` block, and can either replace the mandatory single `catch` block or follow one or more `catch` blocks. They are always guaranteed to execute, even if no exceptions are thrown, and are useful for closing resources that may be left open in memory due to an interruption from a thrown exception.
```java
public void methodThatThrows() throws IOException {
    try {
        throw new IOException();
    } finally {
        System.out.println("Will always run");
    }
}
```

### Try-with-resources
Declaring and defining a resource - any object that implements AutoCloseable - within a pair of parenthesis after the try keyword removes the necessity of a finally block to close that resource.
```java
public void methodThatThrows() throws IOException {
    try (FileReader fr = new FileReader()) {
        throw new IOException();
    } catch (IOException exception) {
        logger.warn("IOException thrown");
    }
}
```

## I/O
### InputStream/OutputStream -> BufferedReader/BufferedWriter
The JVM can connect to external datasources such as files or network ports. InputStream/OutputStream and its implementations stream this data as an array of bytes whereas Reader/Writer and its implementations wrap InputStream/OutputStream to stream data as a char array. BufferedReader/BufferedWriter wraps Reader/Writer to stream several characters at a time, minimizing the number of I/O operations needed.

```java
// Overloaded BufferedReader constructors
BufferedReader sbr = new BufferedReader(new StringReader("Bufferedreader vs Console vs Scanner in Java"));
BufferedReader fbr = new BufferedReader(new FileReader("file.txt"));
BufferedReader isbr = new BufferedReader(new InputStreamReader(System.in));

// Autoclosable, works with try-with-resources syntax
try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
	return readAllLines(reader);
}

// Prone to throwing IOExceptions
public String readAllLines(BufferedReader reader) throws IOException {
	StringBuilder content = new StringBuilder();
	String line;
	while ((line = reader.readLine()) != null) {
		content.append(line);
		content.append(System.ineSeparator());
	}
	return content.toString();
}
```

### Scanner
BufferedReader provides many convenient methods for parsing data. Scanner can achieve the same, but unlike BufferedReader it is not thread-safe. It can however parse primitive types and Strings with regular expressions. Scanner has a buffer as well but its size is fixed and smaller than BufferedReader by default. BufferedReader requires handling IOException while Scanner does not. Thus, Scanner is best used for parsing input into tokenized Strings.

```java
Scanner sc = new Scanner(new File("input.txt"));
Scanner issc = new Scanner(new FileInputStream("input.txt"));
Scanner csc = new Scanner(System.in);
Scanner strsc = new Scanner("A B C D");
```

### Properties
Load properties as key-value pairs from a file
//app.properties
```
key=value
```

```java
Properties props = new Properties();
props.load(new FileInputStream("app.properties");
String value = props.getProperty("key", "defaultValue");
```

## Generics
When passing objects into methods and data structures, a developer can overload or extend for its specific type or cast the object up and down its inheritance heirarchy. In contrast a generic type improves code reuse and type safety, reducing code by allowing methods and data structures to accept any type without risking dynamic runtime exceptions. Generic type parameters act as placeholders in a method signature while diamond operators specify the type for the compiler to enforce at compile time:

```java
ArrayList<String> list = new ArrayList<>();

public <T> String genericToString(T a) {   
    return a.toString();
}


public <T, E> String genericToStrinCat(T a, E b) {   
    return a.toString() + b.toString();
}
```

The type parameters T and E will be replaced by the compiler through type erasure:
```java
String s1 = genericToString(1);
String s2 = genericToString("Hello", 3.5);
```

## Collections Framework
Java's collections framework provides an API and reference implementations for common data structures

- **List** is an ordered collection of elements. A user has the ability to place an element anywhere in the list. The elements are accessable by their index. Unlike **Set**, **List** typically allows for duplicate elements such that element1.equals(element2). In addition to duplicates, **List** allow for multiple null elements to be stored.  
  
- **Set** is a collection of non duplicate elements meaning there will never exist a situation where element1.equals(element2). In addition to this, it is implied that there can only exist one null element due to the no duplicates rule. Some implementations also use **SortedSet** for proper ordering.

- **Queue** is a collection of elements who in essence cannot be iterated, instead the **Queue** follows the **FIFO** (First In First Out) rule. When an element is added to the **Queue** it is placed at the back and when an element is pulled it is pulled from the from the front (index :0).  
  
- **Deque** extends **Queue** but augments the ability to insert and remove elements at either end. The name is short for "Double Ended Queue" and is pronounced "Deck". Can be used as a LIFO (Last In First Out) Stack.
  
- **Map** is an interface which stores data with a key. A map cannot contain duplicate keys; each key can map to at most one value. **Map** can be visualized like a dictionary where only one word is paired with one definition. Unlike most other interfaces in the Collections Framework, it does not implement Collection nor Iterable. 

### Comparable vs Comparator
Comparable is a functional interface used to define a 'natural ordering' between instances of a class, commonly used by sorted collections such as TreeSet.

Comparator is another functional interface used in a dedicated utility class that can compare two different instances passed to it. It can be passed to a sort method, such as Collections.sort() or Arrays.sort(), or to sorted collections.

For example, to automatically sort a TreeSet of type Person according to age. We can either make the object class comparable or pass the constructor a comparator.

#### Comparable
```java
class Person implements Comparable<Person>{
	int age;
 
	Person(int age) {
		this.age = age;
	}
 
	@Override
	public int compareTo(Person o) {
		return o.age - this.age;
	}
}
 
public static void main(String[] args) {
	TreeSet<Person> persons = new TreeSet<Person>();
	persons.add(new Person(43));
	persons.add(new Person(25));
	persons.add(new Person(111));
}
```

#### Comparator
```java
class Person {
	int age;
 
	Person(int age) {
		this.age = age;
	}
}
 
class PersonAgeComparator implements Comparator<Person> {
	@Override
	public int compare(Person a, Person b) {
		return a.age - b.age;
	}
}
 
public static void main(String[] args) {
	TreeSet<Person> persons = new TreeSet<Person>(new PersonAgeComparator());
	persons.add(new Person(43));
	persons.add(new Person(25));
	persons.add(new Person(111));
}
```

## Threads
A *thread* is a unit of program execution that runs independently from other threads. Java programs can consist of multiple threads of execution that behave as if they were running on independent CPUs.

- `java.lang.Thread` is the Thread class representing a thread, which you can extend and then override its run() method. Afterwards, you call start().
- `java.lang.Runnable` is a functional interface (meaning only one method) which you can implement and then override run(). Afterwards, you can pass the object to a Thread instance and run start().
- The `synchronized` keyword is a modifier that can be used to write blocks of code, methods, or other resources to protect it in a multithreaded environment.
- `wait()` and `notify()` or `notifyAll()` methods of `java.lang.Object` can be used to suspend or wake up threads.

Besides the main thread, developers can instantiate their own when:

1. A custom class extends the `Thread` class 
2. A `Thread` is passed an implemented `Runnable` instance

Override the `run()` method in both cases to define the program to be run concurrently in the new thread, then call the Thread instance's `start()` method.

### Extend `Thread`
```java
public class CustomThread extends Thread {
    @Override
    public void run() {
        // Do something
    }

    public static void main(String[] args) {
        new CustomThread().start();
    }
}
```

### Implement `Runnable`
```java
public class CustomRunnable implements Runnable {
    @Override
    public void run() {
        // Do something
    }

    public static void main(String[] args) {
        new Thread(new CustomRunnable()).start();
    }
}
```

### Anonymous `Runnable` Class
```java
new Thread(new Runnable() {
        public void run() {
            // Do something
        }
    }).start();
```

### `Runnable` Lambda
```java
new Thread(
    () -> { /* Do something */ };
    ).start();
```