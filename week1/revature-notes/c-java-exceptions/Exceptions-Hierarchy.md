## Exception Class Hierarchy
![Exceptions hierarchy](https://i.pinimg.com/originals/a6/ab/f3/a6abf35c5fbbb57ebd4e949945839f31.jpg)

The exception class hierarchy starts with the `Throwable` class which inherits from `Object`. Any object which is a `Throwable` can be "thrown" in a program by the JVM or by the programmer using the `throws` keyword. The `Exception` and `Error` classes both extend `Throwable`. An `Error` represents something that went so horribly wrong with your application that you should not attempt to recover from. Some examples of errors are:
* `ExceptionInInitializerError`
* `OutOfMemoryError`
* `StackOverflowError`

`Exception` is a general exception class which provides an abstraction for all exceptions. There are many subclasses of `Exception`, as shown above.