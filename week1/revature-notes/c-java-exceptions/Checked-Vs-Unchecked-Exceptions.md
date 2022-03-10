## Unchecked vs Checked Exceptions
The `Exception` class and all of its subclasses, except for `RuntimeException`, are known as "checked exceptions". These represent occasions where it is reasonable to anticipate an unexpected condition, like a file not existing when attempting to write to it (which would result in a `FileNotFoundException`). **Checked exceptions are required to be handled or declared by the programmer** - otherwise, the code will not compile.

`RuntimeException` is a special type of exception - it, and all of its subclasses - are known as "unchecked exceptions". An **unchecked exception** is an exception that **is not required to be handled or declared** like checked exceptions are. Some examples include:
* `ArithmeticException` for illegal math operations
* `IndexOutOfBoundsException` for if you reference an index that is greater than the length of an array
* `NullPointerException` for if you attempt to perform an operation on a reference variable that points to a `null` value