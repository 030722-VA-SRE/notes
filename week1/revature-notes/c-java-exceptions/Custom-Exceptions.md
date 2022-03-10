## Custom Exceptions
A programmer can create custom exceptions in Java by extending any exception class. If you extend `RuntimeException`, however, you will be creating an unchecked exception. This is a good idea if you do **not** want other code to have to handle your exception being thrown. If you do always want to require your exception to be handled, then create a checked exception by extending any existing one, or the `Exception` class itself.

```java
public class MyCheckedException extends Exception {}
public class MyUncheckedException extends RuntimeException {}

public class ExceptionThrower {

  public static void main(String[] args) {
    try {
	  throw new MyCheckedException("uh oh");
	} catch(MyCheckedException e) {} // we're just ignoring it here
	
    if ( 100 > 1) {
	  throw new MyUncheckedException("you're not required to handle me!");
	}
  }
  
  public static void declareChecked() throws MyCheckedException {
    throw new MyCheckedException("this one is declared!");
  }
}
```