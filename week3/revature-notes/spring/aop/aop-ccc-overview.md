# Aspect Oriented Programming and Cross Cutting Concerns

This page details Aspect Oriented Programming to address Cross Cutting Concerns.

### References
* [Spring 4.0.x Framework Documentation - AOP with Spring](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/aop.html)
* [Spring 4.0.x Framework Documentation - AOP API](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/aop-api.html)
* [JavaDocs API - Spring 4.0.x](https://docs.spring.io/spring/docs/4.0.x/javadoc-api/overview-summary.html)
* [AspectJ API Docs](https://www.eclipse.org/aspectj/doc/released/runtime-api/index.html)
* [AspectJ API Docs - Annotations](https://www.eclipse.org/aspectj/doc/released/aspectj5rt-api/index.html)

## Aspect Oriented Programming and Cross Cutting Concerns
Aspect Oriented Programming is another way to think about structuring your program, which can be used complementary to Object Oriented Programming. In object oriented programming, classes are used as the key component used to drive the creation of objects, which serve the purpose of representing concrete ideas or things with states and behaviors. In Aspect Oriented Programming, the key component are aspects, which modularizes particular transactional concerns which can present across multiple classes, known as _cross-cutting concerns_. Examples of these concerns are, Database Access (security for a database), data entities (transactions to take place), error handling, or logging system messages. The defining characteristic of these _cross-cutting concerns_ is that they are actions that can take place across your classes, regardless of the class function or structure. In traditional object oriented programming, this would result in code redundancy, as the same code must be called multiple times throughout an application to perform these actions. Aspect Oriented Programming works to eliminate this redundancy by transferring responsibility of these common problems to aspects. Note that the Spring IoC Container is not dependent on AOP; however, the Spring AOP framework complements the IoC Container by providing a capable middleware solution for concerns.

### Important Terminology
* _Aspect_ - A representation of a concern which cuts across multiple classes.
* _Weaving_ - The process of linking aspects with other objects, such as beans, to create advised objects. This can be done at compile time (such as when using the AspectJ compiler), load time or runtime. Spring performs weaving at Runtime.
* _Join Point_ - A specified moment during the execution of a program, such as the invocation of a method, in which actions can be taken.
* _Advice _ - Action taken by an aspect at a specified Join point. 
* _Pointcut_ - A definition of which methods in our application advice ought to be injected into or around, for example, when a method of a certain name is executed. By default, spring uses AspectJ pointcut expression language.
* _Introduction_ - Declaration of new interfaces and corresponding implementations in subclasses of any advised object. Introductions use the `@DeclareParents` annotation with the _defaultImpl_ attribute to define a default concrete class for the bean definition. For Example:

__IFunction Interface__:
```
package com.revature.examples;

public interface IFunctional {
    public void function();
}
```

__FunctionalDefault__:
```
package com.revature.examples;

public class FunctionalDefault implements IFunctional {
    public void function() {
        System.out.println("This is the default function");
    }
}
```

__Aspect__:
```
package com.revature.examples;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectExample {
    @DeclareParents(value="com.revature.examples.*+",defaultImpl=FunctionalDefault.class)
    public static IFunctional iFunctional;
}
```
The '+' after the package is used to match the class (or interface) and all subclasses. This pointcut expression will match any interfaces or classes defined in the package `com.revature.examples` and also any subclass or implementing class of these classes, even if the implementing class or subclass is in another package.
* _Target Object_ - The object which is being advised by one or more aspects. The Spring AoP is implemented using proxies, and as such, this target object will always be a proxied object.
* _AOP Proxy_ - An object created in an AoP framework in order to implement advice defined in aspects. The utilization of these proxies allows for loose coupling between your advice targets. The Spring AoP framework supports JDK dynamic proxies (which is interface based) as well as a CGLIB proxy (which is class based).

Below is a visual representation of how the Spring Transaction proxy works:

![Spring Transactional Proxy](./transactional-proxy.png)

At a high-level, when a method is invoked an AOP Proxy is informed, which informs the associated Advisor (in this case a transaction advisor). This advisor implementation can then inject advice as needed (based on configuration) before, or after invoking the target method. Note that additional custom advisors can come before or after the transaction advisor is run.
