## Reading User Input from Console
The `Scanner` class can be used to read user input from the command line:

```java
Scanner sc = new Scanner(System.in);
while (true) {
  String input = sc.readLine();
  System.out.println("Your input: " + input);
}
```

When the code above is run, the program acts to "echo" back any input given from `stdin`.