## Casting
[Casting](https://en.wikipedia.org/wiki/Type_conversion) is the process of converting a data type to another data type. This is also called **type casting**. Casting is necessary is some situations when we receive a data type that needs to have some actions performed on it that its original form cannot handle.

When working with some primitive numeric types, Java will automatically do this conversion. This automatic conversion is supported when the types are compatible with range and precision. The original data type must have a smaller size in memory (and thus is capable of holding a smaller range in values) than the target type. The target type must also hold the same or greater precision past the decimal point, so that there is no data lost in the conversion.

In the example below, an int (size of 32 bits) is being cast to a double (size of 64 bits). Due to their comparable size in memory, Java is able to do this conversion automatically without the loss of any data. And because we're going from a data type that only supports integer values to a data type that holds decimals, we risk no loss of precision.

```java
public class AutomaticCasting {

  public static void main(String[] args){
    int n = 10;
    double d = n; //This is now converted from an int to a double.
  }
}
```

However, cases where the original data type is larger than the target type, you will have to explicitly convert them using parentheses. There can be data loss using this method, as the target type is not always able to represent the original value.

```java
public class ExplicitCasting {

  public static void main(String[] args){
    short s = 150;
    byte b = s; // this will not compile without an explicit cast 
    // and in this case, even with an explicit cast, there will be data loss
    // as bytes can only hold values up to 127
    // b would actually hold the value -106 here
  }
}
```


```java
public class ExplicitCasting2 {

  public static void main(String[] args){
        float f = 10.23f;
        int i = f; // this wil also not compile without an explicit cast 
        // although floats and ints are both represented in memory with 32 bits, floats can hold decimal values while ints cannot
        // we can explicitly cast these values, but we lose .23
        // i holds the value 10
  }

}
```

In some cases you will have to use the data type's own methods to convert. Some of these methods are listed in the table below.

| Original |   Target  |           Method         |
| ---------| --------- |--------------------------|
| String   | int       |Integer.parseInt(String); |
| int      | String    |String.valueOf(int);      |

You are also able to cast subclass objects to their superclasses which is called upcasting and cast superclass objects to their subclasses (This has some limitations and prerequisites).
