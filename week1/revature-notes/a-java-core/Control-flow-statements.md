### Control Flow Statements
Java, like most other languages, has a few keywords that define statements which control the flow of program execution:
* `if/else if/else`
* `for`
* `while`
* `do-while`
* `switch`

#### If statements
The basic syntax of `if` statements:
```java
if (condition) { // this is the only block that is required - others are optional
  statement1;
} else if (condition2) {
  statement2;
} else {
  statement3;
}
```

#### For loops
For-loops are used for iteration, often in conjunction with data structures. They include 3 statements in parentheses - a declaration, condition, and statement (typically increment or decrement).
```java
for (int i=0; i < myData.length; i++) {
  // typical for loop
  System.out.println(myData[i]);
}
```

Any object which implements the `Iterable` interface can be iterated over using an **enhanced for-loop**. The syntax is given in an example:

```java
List<String> myList = getListOfStrings();
for (String myStr : listOfStrings) {
  System.out.println(myStr);
}
```

#### While statements
While statements test a condition - if the condition evaluates to true the block of code is run, otherwise the block is skipped. The block is looped through as long as the condition remains `true`.
```java
while (true) {
  // infinite loop!
}
```

An alternative to `while` loops is the `do-while` loop. This guarantees that the block will always run at least once:
```java
do {
  // always runs at least once!
} while(condition); // condition evaluated after the block of code, and the do block will run subsequently until the condition evaluates to false
```

#### Switch statements
`switch` statements attempt to match some variable with the value it contains. This type of statement works with `byte`, `short`, `char`, and `int` primitives, along with enumerated types (`enum`s) and - since Java 7 - `String`s. The basic syntax is:

```java
switch(variable) {
  case 'A': System.out.println("Case A matches!"); break; // break is REQUIRED, unless you want control flow to "fall through" to the next case, or unless your switch case returns something and exits the method
  case 'B': System.out.println("Case B matches!"); break;
  case 'C': System.out.println("Case C matches!"); break;
  default: System.out.println("this will run if other cases don't match"); break;
}
```