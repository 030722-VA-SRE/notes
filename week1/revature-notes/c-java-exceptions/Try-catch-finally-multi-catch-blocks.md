## Try/catch/finally Blocks
In order to handle exceptions that could be thrown in our application, a `try/catch` block can be used. The `try` block encloses the code that may throw an exception, and the `catch` block defines an exception to catch and then runs the code inside only if that type of exception is thrown. We can optionally include a `finally` block which will run whether an exception is thrown or not. A simple example is shown below:
```java
try {
  object.someRiskyMethodCall();
} catch(Exception e) {
  System.out.println("phew! that was close!");
} finally {
  System.out.println("I'll run whether there was a problem or not!");
}
```

### Try/catch/finally & Multi-catch Block Rules
Catch and finally blocks have several different rules which must be followed:
* Multiple catch blocks are allowed. More specific exceptions must come before more general exception types.
* Multi-catch blocks (catching more than one exception in a given block) are allowed, exception types are separated by `||`
* The `finally` block is optional
* A `try/finally` block only IS allowed, but a `try` block by itself is not
* A `finally` block will always execute, unless of course `System.exit()` is called.