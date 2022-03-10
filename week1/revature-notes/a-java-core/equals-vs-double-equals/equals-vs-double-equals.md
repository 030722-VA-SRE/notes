# Dot-Equals vs Double-Equals

_What is the difference between equals() and == ?_

A large discussion can be had around the difference between the method `equals()` and the `==` relational operator.

Both are used to compare two things and return a boolean value, however, they are used in different scenarios. The operator `==` is used to compare the _value_ of **primitives** as in the following scenario:

```java
int x = 6;
int y = 5;
if (x == 6){ .. }
```

If you compare two **reference variables** using the `==` operator will compare the reference address of the objects each variable points to. It may not return true even if the _contents_ of those two objects are the same.

For example, comparing two Strings (when one is created using the **new** operator) will return false.

```java
String s = "Hello";
String s2 = new String("Hello");
if (s == s2) {..}
```

The above if-statement will not execute because s is not equal to s2.

In the case of objects (yes, `String` is an object; there is a `String` class), the `==` operator compares the memory location of these variables. Objects have their own place in memory and each time you create a new object, it'll have its own memory address and thus the `==` operator will return false.

This is why we use the `equals()` method with objects. It is expected to that it will help us compare the _values_ of objects with one another.

Thus in our String example, we would use `equals()` instead of `==` and the if-statement would execute:

```java
String s = "Hello";
String s2 = new String("Hello");
if (s.equals(s2)) {..}
```

This is because the `equals()` method of the `String` class has been overridden to compare the contents of the current `String` and one passed in as an argument.

Later in the course, you'll learn what it means to override a method. Using this concept, you'll be able to create your own custom Classes and override the `equals()` method to tell your program how to compare your custom class to another.