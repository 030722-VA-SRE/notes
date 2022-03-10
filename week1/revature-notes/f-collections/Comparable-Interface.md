## Comparable Interface

[`Comparable`](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html) is an interface which defines the natural ordering for a class. A class must implement `Comparable` if it is to be sorted by the `compareTo()` method.
```java
public interface Comparable<T> {
	public int compareTo(T o);
}
```

The `compareTo()` method returns an `int` which is:
* Zero, if the two objects are equal
* Negative, if this object is smaller than that
* Positive, if this object is greater than that

