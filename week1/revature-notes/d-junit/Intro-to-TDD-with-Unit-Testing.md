## TDD
When developing software, it is important to ensure that most if not all of the code being written is tested to verify the functionality of the code. One way to ensure this is to follow a process called **test-driven development**, or TDD.

### TDD Process
The TDD process consists of writing unit tests first, **before** the application code has been written. Then, code can be written to make the test pass and the process can be completed for each piece of functionality required. Thus, the process is:
1. Write a unit test
2. Run the test => test will fail
3. Fix the test by writing application code
4. Retest until the test passes
5. Repeat

Following the TDD process can be useful for ensuring that a valid unit tests always exists for any class or method that is written. Later, when refactoring code, the unit tests give us confidence that we can change the source code without breaking existing functionality. If we mess up somewhere, when the unit tests are run we can pinpoint exactly where the problem lies. This makes debugging much easier.

## Unit Testing
Unit testing is the testing of individual software components in isolation from the rest of the system. This is done by writing unit tests which execute the code we want to inspect. When the code under test deviates from an expected outcome or behavior, the test will fail. If a test passes, it means the application performs as expected (unless there is a problem with the test itself). In Java, the most common unit testing framework is called JUnit.