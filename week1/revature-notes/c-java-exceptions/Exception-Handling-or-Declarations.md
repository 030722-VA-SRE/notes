## Exceptions
When an exceptional condition occurs in the course of a Java program, a special class called an `Exception` can be **thrown**, which indicates that something went wrong during the execution of the program. If the exception is not handled anywhere in the program, it will propagate up through the call stack until it is handled by the JVM which then terminates the program.

### Exceptions Handling / Declaring Exceptions
When risky code is written that has the possibility of throwing an exception, it can be dealt with in one of two ways:
1. Handling means that the risky code is placed inside a try/catch block
2. Declaring means that the type of exception to be thrown is listed in the method signature with the `throws` keyword. This is also called "ducking" the exception - you let the code which calls the method deal with it.
