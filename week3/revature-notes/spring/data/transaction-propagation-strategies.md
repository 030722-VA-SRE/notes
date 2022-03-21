# Transaction propagation

The page details the general purpose usage of transaction propagation strategies, but in the context of spring with hibernate and transaction management. A link for transaction propagation with JDBC can be found in the references.

### References

- [Spring Transaction Management](https://docs.spring.io/spring-framework/docs/4.3.x/spring-framework-reference/html/transaction.html)
- [Spring Propagation Types](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Propagation.html)
- [JDBC Transaction Propagation](https://docs.oracle.com/cd/A87860_01/doc/java.817/a83725/trans1.htm#1108707)

## Transaction Propagation.

When designing database transactions to be performed in Java or any other programming language other than SQL, it is important to ask this question, "How will transactions behave over multiple method calls"? If `Method1` calls `Method2, how will transactions propagate. Transaction propagation falls into the following categories.

|   Strategy    | Purpose                                                                                              |
| :-----------: | :--------------------------------------------------------------------------------------------------- |
|   Mandatory   | Support a current transaction, throw an exception if none exists.                                    |
|    Nested     | Execute within a nested transaction if a current transaction exists, behave like REQUIRED otherwise. |
|     Never     | Execute non-transactionally, throw an exception if a transaction exists.                             |
| Not Supported | Execute non-transactionally, suspend the current transaction if one exists.                          |
|   Required    | Support a current transaction, create a new one if none exists.                                      |
| Requires New  | Create a new transaction, and suspend the current transaction if one exists.                         |
|   Supports    | Support a current transaction, execute non-transactionally if none exists.                           |

### Spring Transaction Management

Designing transactions and ensuring consistency isn't necessarily trivial, but using a transaction manager can help aleviate some of the more complex tasks such as read/write locking and thread management. As we know `Spring` integrates with `Hibernate` with reasonable ease and integrating a transaction manager is a matter of configuring `Hibernate` to do so. So how is transaction propagation performed? Refer to the notes on `@Transactional` to learn how it is used to create `contextual sessions`. Below will be a discussion on the `propagation` attribute of the annotation which is used to setup transaction propagation.

### Propagation Usage

```java
@Service
public class MyService {
    ...

    @Transactional(readonly=true, propagation=Propagation.NEVER)
    public List<MyData> readMyData(){...}
}
```

The above code use the transaction manager to create a read only, transactionless transaction state. Generally speaking readonly operations are idempotent and safe so an argument for never having a transaction present can be made. This is not necessarily a best practice.

```java
@Service
public class MyService{
    @Autowired
    private MyService2 myService2;
    ...
    @Transactional(propagation=Propagation.REQUIRED_NEW)
    public Integer createNewData(...){
        myService2.createSupportingData(...);
        ....
    }
}

@Service
public class MyService2{
    ...
    @Transactional(propagation=Propagation.MANDATORY)
    public Integer createSupportingData(...){...}
}
```

The above code creates a more complicated situation. From the `MyService` perspective, it is easy to see that the `createNewData` method will require a new transaction be created, but the dependency on `MyService2` complicates the operation. The example simplifies the problem by assuming that `createSupportingData` of `MyService2` not only requires a transaction, but will fail if one isn't present. Essentially the example creates a situation where the data write for `MyService` is contigent on the data write from `MyService2` at the transaction level, using this strategy we have created an atomic multioperational transaction which will increase the likely hood of maintaining a consistent state.

## Important Note

Transaction management design is a multipart problem. Remember database transactions should be A.C.I.D. The solution to transaction management should be as organic to your problem as possible. There are no cookiecutter solutions that will fit all problems.
