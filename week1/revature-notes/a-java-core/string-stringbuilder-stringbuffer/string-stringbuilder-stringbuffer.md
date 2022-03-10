# String vs StringBuilder vs StringBuffer

In Java, both the String class and the value stored inside a String object are `final`, and thus immutable. The `String` class cannot be extended, and once instantiated, the value inside a String object cannot be changed. Every time you modify a `String` object in Java, a new `String` object is created.

For example:

```java
String var1 = new String ("Hello ");
String var2 = new String ("World");
var1 = var1 + var2;
var2 = "Example";
```

Each line above creates a new `String` object in memory.

If you want to create a _mutable_, i.e. changeable string, you would use a `StringBuilder` or `StringBuffer` object. These objects allow the text value they contain to be changed at will, and they provide several utility methods for manipulating their contents in different ways.

However, consider a situation where two separate processes (called threads) are running at the same time, and both processes need to access the same text at the same time, and one process will change it. With a `String` object, this is not a problem - when one of the processes changes a `String`, it gets a new `String` object and the original remains unchanged. If the text value were mutable though, then the value returned to one process would depend on whether the other has edited it yet. This means that our editable text is _not thread-safe_. 

You can use a `StringBuffer` whenever you need a mutable string object, and also need it to be _thread-safe_. A `StringBuffer` object will guarantee that only one thread can access it at a time, preventing confusion. This can slow performance.

A `StringBuilder` is a wrapper for a mutable string, but it is _not_ thread-safe. You use a `StringBuilder` when you are not using threads, or are performing thread control safely somewhere else.