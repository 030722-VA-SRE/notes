# Spring Data Annotations

This page is a brief overview of the some of the Spring Data annotations. Please see the reference links for the official documentation

### References

- [Spring Data Annotations](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/annotation/package-summary.html)

## Spring Data Annotations

Spring Data abstracts away the code required for data storage solutions, allowing us to focus more on the business logic. The following is a list and brief explanation of some common Spring Data annotations which allow us to configure how the queries are executed.

| Annotation                      | Purpose                                                                                   |
| ------------------------------- | ----------------------------------------------------------------------------------------- |
| @Transactional                  | Configure how the database transaction behaves. See the @Transactional notes.             |
| @NoRepositoryBean               | Creates and interface that provides common methods for child repositories                 |
| @Param                          | Parameters can be passed to queries defined with @Query                                   |
| @Id                             | Marks a field in a model class as the primary key                                         |
| @Transient                      | Mark a field as transient, to be ignored by the data store engine during reads and writes |
| @CreatedBy, @LastModifiedBy     | Auditing annotations that will automatically filled with the current principal            |
| @CreatedDate, @LastModifiedDate | Auditing annotations that will automatically fill with current date                       |
| @Query                          | Supply a JPQL query for repository methods                                                |

### @Transactional

See the notes on the @Transactional annotation for multiple examples

### NoRepositoryBean

```java
@NoRepositoryBean
public interface MyRepoBase<T, ID extends Serializable> extends JpaRepository<T, ID> {
    Optional<List<T>> findAllByPrice(Double price);
}

@Repository
public inteface BookRepo extends MyRepoBase<Book, Integer> {}
```

The interface `MyRepoBase` can now serve as a base for children repos like `BookRepo`. Spring will not create a bean of type `MyRepoBase`, but will create a `BookRepo` bean which will include all of the `JpaRepository` methods and also `findAllByPrice` from `MyBaseRepo`

### @Param

```java
@Repository
public inteface BookRepo extends MyRepoBase<Book, Integer> {

    @Query("FROM Book b WHERE b.title LIKE :title")
    Optional<List<T>> findBySimilarTitle(@Param("title") String title);
}
```

The `@Param` annotation binds the method parameter to the `title` parameter of `@Query`.

### @Id

This is essentially the same as the JPA annotation.

### @Transient

This is essentially the same as the JPA annotation.

### @CreatedBy, @LastModifiedBy, @CreatedDate, @LastModifiedDate

```java
public class Book {
    @CreateBy
    public User creator;

    @LastModifiedBy
    public User modifier;

    @CreatedDate
    public Date createdAt;

    @LastModifiedDate
    public Date modifiedAt;
}

```

### @Query

```java
@Query("SELECT COUNT(*) FROM Book b)
long getBookInventoryCount();
```

JPQL query.

```java
@Query("FROM Book b WHERE b.title LIKE :title")
Optional<List<T>> findBySimilarTitle(@Param("title") String title);
```

With named parameters.

```java
@Query("SELECT AVG(b.page_count) FROM Book b", nativeQuery=true)
int getAvgPageCount();
```

Natvie SQL query.
