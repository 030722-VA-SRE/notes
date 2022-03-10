## Comparator Interface

[`Comparator`](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html) is an interface which allows you to define a total ordering on some collection of objects. A class that is to be sorted by `compare()` does not have to implement `Comparator`.
```java
public interface Comparator<T> {
	public int compare(T firstObject, T secondObject);
}
```