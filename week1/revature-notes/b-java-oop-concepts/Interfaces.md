## Interfaces

An interface acts as a contract for behaviors that a class can implement.

```java
public interface InterfaceA {
 public void methodName(); //You don't implement the method!
}
```
Interfaces have implicit modifiers on methods and variables.
- Methods are 'public' and 'abstract'
- Variables are 'public', 'static', and 'final'
To inherit interfaces, a class must *implement* them and they are REQUIRED to implement all methods, unless the class is abstract.