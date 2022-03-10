## Try-with-resources
When using `try/catch` blocks, often times some object used in the code is a resource that should be closed after it is no longer needed to prevent memory leaks - for example a `FileReader`, `InputStream`, or a JDBC `Connection` object. With Java 7, we can use a `try-with-resources` block which will automatically close the resource for us:

#### Old way
```java
try {
  InputStream is = new FileInputStream("./some/file.ext");
  String s = is.read();
} catch(IOException e) {
} finally {
  is.close();
}
```

#### New way
```java
try(InputStream is = new FileInputStream("./some/file.ext")) {
  String s = is.read();
} catch(IOException e) {}
```

Whatever is placed within the parenthesis of the `try` statement will be closed automatically - thus, we don't need to explicitly call it within our `finally` block above. This new format requires the object in the `try` statement to **implement the [AutoCloseable](https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html) interface**.