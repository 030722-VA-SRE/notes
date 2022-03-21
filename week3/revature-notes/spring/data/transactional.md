# @Transactional

The page details the use of `@Transactional` in Spring to utilize transaction management and contextual sessions.

### References

- [Spring @Transactional](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Transactional.html)
- [Spring Transaction Management](https://docs.spring.io/spring-framework/docs/4.3.x/spring-framework-reference/html/transaction.html)
- [JDBC Transaction Propagation](https://docs.oracle.com/cd/A87860_01/doc/java.817/a83725/trans1.htm#1108707)

## Transaction Management

When designing database transactions to be performed in Java or any other programming language other than SQL, it is important to consider that multiple transactions will performed simultaneously. Managing all of these transactions can be tedious and cumbersome becuase it requires complicated strategies for read/write locking and thread management. JDBC and connection pool utilities like Hikari have built-in tools for handling these issues, but still will require a lot of boiler plate code to achieve the consistency required for your data.

## @Transactional

When using `Spring` and `Spring ORM` or `Spring Data` your chosen ORM can be configured to use a transaction manager that will automatically handle transaction propagation, and isolation, commit, and rollback. Assuming you understand how to configure `Spring` to use `Hibernate` and a `TransactionManager`, utilizing the management tools is as simple as annotating a class or method with `@Transactional`.

For best practice usage `@Transactional` should be used on your `@Service` beans since a transaction is a unit of work with its success or failure directly tied to the requirements of the application and not necessrarily to the model. The side-effects of a transaction can be assumed to be either `commit` or `rollback` therefore the model will be consistent, but the `@Service` will be required to react accordingly.

Below is a list of the attributes for `@Transactional`

| Attribute              | Purpose                                                                                                                                                                 |
| ---------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| isolation              | The transaction isolation level.                                                                                                                                        |
| noRollbackFor          | Defines zero (0) or more exception Classes, which must be subclasses of Throwable, indicating which exception types must not cause a transaction rollback.              |
| noRollbackForClassName | Defines zero (0) or more exception names (for exceptions which must be a subclass of Throwable) indicating which exception types must not cause a transaction rollback. |
| propagation            | The transaction propagation type.                                                                                                                                       |
| readOnly               | A boolean flag that can be set to true if the transaction is effectively read-only, allowing for corresponding optimizations at runtime.                                |
| rollbackFor            | Defines zero (0) or more exception classes, which must be subclasses of Throwable, indicating which exception types must cause a transaction rollback.                  |
| rollbackForClassName   | Defines zero (0) or more exception names (for exceptions which must be a subclass of Throwable), indicating which exception types must cause a transaction rollback.    |
| timeout                | The timeout for this transaction (in seconds).                                                                                                                          |
| transactionManager     | A qualifier value for the specified transaction.                                                                                                                        |

### @Transactional Usage

The following examples assume the usage of `Spring ORM` since the query structure and operations of `Spring Data` are abstracted away.

```java
@Service
@Transactional // all methods in this class will utilize the tx manager and contextual sessions
public class MyService {
    ...
    public List<MyData> readMyData(...){...}
}
```

The above code creates a service bean that utilizes the transaction manager. By annotating the class, all methods are implicated in the use of the manager.

```java
@Service
@Transactional // all methods in this class will utilize the tx manager and contextual sessions with default configuration
public class MyService {
    ...
    @Transactional(readonly=true, isolation=Isolation.READ_COMMITTED, propagation=Propagation.NEVER) //override the default config
    public List<MyData> readMyData(...){...}
}
```

The above code expands on the previous example. `@Transactional` can be used on classes or methods or both. In this example, the class uses the transaction manager with default configuration, but the method overrides the default configuration. If you are unfamiliar with the attributes being used, don't worry to much about that right now.

```java
@Service
@Transactional // all methods in this class will utilize the tx manager and contextual sessions
public class MyService {
    ...
    @Transactional(isolation=Isolation.SERIALIZABLE, rollbackFor={ConstraintViolationException.class}, propagation=propagation.REQUIRES_NEW) // override when the transaction should rollback.
    public Integer createNewData(...){...}
}
```

In the above example the code demonstrates how to configure the transaction manager with a list of exceptions that must cause a rollback to be triggered. Normally the transaction manager will always rollback for any RuntimeException or RuntimeException subclass (unchecked exceptions) however, the transaction manager will not automatically rollback for Exception (checked exceptions)

## Important Note

Transaction management design is a multipart problem. Remember database transactions should be A.C.I.D. The solution to transaction management should be as organic to your problem as possible. There are no cookiecutter solutions that will fit all problems.
