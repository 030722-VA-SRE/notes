## StringBuffer and StringBuilder

Since Strings are immutable, it becomes inefficient to use them if we are making many new Strings constantly, for example if we are generating new Strings in a `for` or `while` loop. Instead, we can use the `StringBuilder` and `StringBuffer` classes, both of which are **mutable**. [`StringBuilder`](https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html) contains helpful methods like `.append()` and `.insert()` which mutate its internal sequence of characters. [`StringBuffer`](https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuffer.html) is like `StringBuilder` but is synchronized, which is useful for multi-threaded applications.

| Class | Immutable? | Thread-safe? | Speed |
| ----  | ---------- | ------------ | ----- |
| String | Y | Y | Slowest |
| StringBuilder | N | N | Fastest |
| StringBuffer | N | Y | Fast |

[`StringTokenizer`](https://docs.oracle.com/javase/8/docs/api/java/util/StringTokenizer.html) is a related class which can parse a String and splits it based on a delimiter.