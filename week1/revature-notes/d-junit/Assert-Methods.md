## Assert Methods
When writing a test method, JUnit helps us check the functionality of the code being tested by providing static `Assert` methods, of which there are many. A few include:
* `assertTrue()`
* `assertFalse()`
* `assertEquals()`
* `assertNotEquals()`
* `assertThat()`

Assertions verify that the state of the application meets what is expected. For example, to test a simple addition method:

```java
@Test
public void additionTest() {
  Assert.assertEquals(4, Calculator.addNumbers(2,2));
}
```

If the `.addNumbers()` method returns anything other than `4`, the test will fail. This will alert us that something is wrong in the logic of the method and we can then debug the issue. When we think we've fixed the problem, just run the test again and check that it passes.

**Note:** to avoid needing to reference `Assert` every time, we can use a `static import org.junit.Assert.*;` statement to import all `static` members of the `Assert` class.