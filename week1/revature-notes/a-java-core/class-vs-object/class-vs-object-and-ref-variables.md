# Classes vs Objects and Reference Variables

In Java, it's important to understand the difference between a `class`, an **object**, and a **reference variable**.

A `class` is a template used to instantiate objects. It's also called a _type_ when used with a reference variable. A class that is used to instantiate an object determines what state and behavior an object will possess. A class used as the type for a reference variable determines what behaviors of an object can be invoked, and how any variables get initialized.

An **object** is an instance of a class in memory. In Java, you _never interact with objects directly_. Instead, you interact with them through their reference, which is the memory address used by the JVM to find a particular object.

A **reference variable** is a variable that stores the reference to an object in memory. Just like the type of a primitive variable determines the range of values that a primitive variable can store, the type of a reference variable determines what types of objects a reference variable can store a reference to. 

When a class is used as the type of a reference variable, that reference can only be used to invoke behaviors of the object that are declared in the class/type.

Let's look at the following line of code that we've divided into three parts:

| 1 | 2 | 3 | 
| -- | -- | -- |
| String  | someVar  | = new String("Hello World"); |



1. The class/type of the reference variable
2. The name of the reference variable
3. The instantiation of a new object using the new keyword to invoke the constructor

* The someVar reference variable does not contain a String object, it contains a reference that points to it in memory
* The String type means that someVar can only store a reference to an object that is an instance of the String class (directly or through inheritance)
* The String type means that someVar can only be used to invoke methods or access public variables present in the String class (whether defined in String or inherited from a superclass)
* The `new String("Hello World")` expression creates an object, it is not the object itself. You can never access the object directly. 

Understanding these concepts and their implications is key to properly understanding the Java language.