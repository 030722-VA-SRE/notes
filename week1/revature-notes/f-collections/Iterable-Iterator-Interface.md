## Iterable and Iterator Interface
The `Iterable` interface defines a data structure which can be directly traversed using the `.iterator()` method, which returns an `Iterator`. This can be useful for fine-grained control over iteration. The `Iterator` interface contains methods for traversal, including:
* `hasNext()`
* `next()`
* `remove()`

For example:

```java
Set<String> names = new ArrayList<>();
// add names...
Iterator<String> it = names.iterator();
while (it.hasNext()) {
  String name = it.next();
  doSomething(name);
}
```

### Enhanced For Loop
Any object which implements the `Iterable` interface can also be iterated over using a special kind of `for`-loop: the "enhanced" for loop. The syntax is as follows:
```java
Set<String> names = new ArrayList<>();
// add names...
for (String name : names) {
  System.out.println(name);
}
```
The downside of the enhanced for loop is that the index of iteration is not tracked, so fine-grain control over execution is not possible. However, this simplified syntax is beneficial for many simple iterations.