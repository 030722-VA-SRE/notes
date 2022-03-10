## Wrapper Classes
Wrapper classes are classes that let you treat primitives as Objects. This is necessary - for example - for certain methods which only accept objects and not primitives. **Boxing** is the process of converting a primitive to its wrapper class. Java has a feature called **autoboxing** which will automatically convert primitives to wrapper classes implicitly. **Unboxing** is the reverse - converting a wrapper class to its primitive. Below the wrapper classes are listed:

| Primitive | Wrapper Class |
| --------- | ------------- |
| boolean   | Boolean       |
| byte      | Byte          |
| short     | Short         |
| char      | Character     |
| int       | Integer       |
| long      | Long          |
| float     | Float         |
| double    | Double        |

Wrapper classes have static helper methods like `.parseX()` and `.valueOf()` for explicit primitive conversion.

```java
public class AutoboxingExample {

  public static void main(String[] args) {
    int n = 5;
    someMethod(n); // autoboxing is done here!
	// 8
  }
  
  public static void someMethod(Integer i) {
    System.out.println(i + 3);
  }
}
```