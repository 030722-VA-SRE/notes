## Methods and Parameters

A method is a block of code which only runs when it is called. You can pass data, known as parameters, into a method. A method must be declared within a class. It is defined with the name of the method, followed by parentheses `()`.

Example:
```java
public class MyClass {
  public static void myMethod() {
    // code to be executed
  }
}
```

Parameters are specified after the method name, inside the parentheses. You can add as many parameters as you want, just separate them with a comma.

Example:
```java
public class MyClass {
  public static void myMethod(String name) {
    System.out.println(name);
  }

  public static void main(String[] args) {
    myMethod("Liam"); 
    myMethod("Jenny");
  }
}
//Output:
//Liam
//Jenny
```