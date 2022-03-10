## JUnit Annotations
JUnit is a Java framework for unit testing. JUnit has several annotations within the `org.junit` package that developers can use to create tests and setup test environments:
* `@Test` - declares a method as a test method
* `@BeforeClass` - declares a setup method that runs once, before all other methods in the class
* `@Before` - declares a setup method that runs before each test method
* `@After` - declares a tear-down method that runs before each test method
* `@AfterClass` - declares a tear-down method that runs once, after all other methods in the class

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

### Ignoring Tests

To prevent a test from running, use the `@Ignore` annotation. Use this sparingly, however, because ignoring valid tests only means that you are pretending a problem does not exist. If tests are constantly ignored, you will have no guarantee that the application functionality has not regressed.

### Testing Best Practices
When it comes to testing code, a few best practices to follow include:
* [Utilize dependency injection](https://en.wikipedia.org/wiki/Dependency_injection)
* [Write testable code](https://www.toptal.com/qa/how-to-write-testable-code-and-why-it-matters)
* Use a mocking library like [Mockito](https://site.mockito.org/) for dependencies
* Measure your code coverage with a tool like [Jacoco](https://www.eclemma.org/jacoco/trunk/doc/maven.html)
* Externalize test data when possible (i.e. read in the test data from an external file or generate it dynamically)
* Generally, you want to use **only 1 assert statement per test** - this ensures you can pinpoint the defect when debugging
* Write deterministic tests (they shouldn't fail sometimes and pass other times - otherwise known as "flaky" tests)
