# Spring Module - Hibernate Integration with Contextual Sessions

This page details integration of Hibernate contextual sessions with the Spring Framework.

### References
* [Spring 4.0.x Docs - ORM](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/orm.html#orm-hibernate)
* [Spring and Hibernate 3 - Baeldung](https://www.baeldung.com/hibernate3-spring)
* [Spring and Hibernate 5 - Baeldung](https://www.baeldung.com/hibernate-5-spring)
* [Hibernate Documentation - 3.6 SQL Dialect Support](https://docs.jboss.org/hibernate/orm/3.6/reference/en-US/html_single/#configuration-optional-dialects)
* [Hibernate Documentation - 5.2 SQL Dialect Support](https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#database-dialect)

## Hibernate-Integration
As discussed in the [Spring ORM](https://gitlab.com/revature_training/spring-team/-/tree/master/modules/a-framework/spring-orm/md) notes, Spring can utilize hibernate ORM as a means to store scaler values within relational databases. Most applications, when using Hibernate, need some form of "contextual" session, wherein data regarding the specific session is available, and in effect throughout the scope of the given context. Across different applications this "contextual" session and the different scopes can vary depending on the application environment. As previously discussed, Spring provides support for Hibernate sessions through the use of the `SessionFactory`. 

Much like other Spring integrations, Hibernate configurations can utilize Java-Based or XML-based configurations. Note that as of Spring 4 you must use Hibernate version 3.6 or later. Additionally, configuration for Hibernate has changed slightly between Hibernate 3 and Hibernate 5. As such, the following details both Hibernate 3 as well as Hibernate 5 configurations:

### Hibernate 3.6
To start, we will use a Maven Java project. To enable Hibernate, we must add the following Dependencies  to our pom file:

__Maven POM Dependencies__
Hibernate Version (3.6):
```
<dependency>
   <groupId>org.hibernate</groupId>
   <artifactId>hibernate-core</artifactId>
   <version>3.6.10.Final</version>
</dependency>
```

Hibernate proxy Model:
```
<dependency>
   <groupId>org.javassist</groupId>
   <artifactId>javassist</artifactId>
   <version>3.18.2-GA</version>
</dependency>
```

Database Support:
```
<dependency>
    <groupId>com.h2database</groupId> 
    <artifactId>h2</artifactId>
    <version>1.2.140</version>
</dependency>
```

Spring Datasource Implementation:
```
<dependency>
    <groupId>org.apache.tomcat</groupId>
    <artifactId>tomcat-dbcp</artifactId>
    <version>7.0.55</version>
</dependency>
```

Next, we need the configuration. Java Configuration requires the definition of beans using the `@Bean` annotation. Additionally, we can use the `@Autowired` annotation to inject beans as needed (such as for the Session Factory). 

__Java Configuration__
```
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.google.common.base.Preconditions;
 
@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
@ComponentScan({ "com.revature.example.persistence" })
public class PersistenceConfig {
 
   @Bean
   public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(dataSource());
      sessionFactory.setPackagesToScan(new String[] { "com.revature.example.model" });
      sessionFactory.setHibernateProperties(hibernateProperties());
 
      return sessionFactory;
   }
 
   @Bean
   public DataSource dataSource() {
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName("org.h2.Driver");
      dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
      dataSource.setUsername("user");
      dataSource.setPassword("password");
 
      return dataSource;
   }
 
   @Bean
   @Autowired
   public PlatformTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
      HibernateTransactionManager txManager = new HibernateTransactionManager();
      txManager.setSessionFactory(sessionFactory);
 
      return txManager;
   }
 
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      return new PersistenceExceptionTranslationPostProcessor();
   }
 
   Properties hibernateProperties() {
      Properties hibernateProperties = new Properties();
      hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
      hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

      return hibernateProperties;
   }
}
```

__XML Configuration__
```
<bean id="sessionFactory"
  class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
    <property name="dataSource" ref="dataSource" />
    <property name="packagesToScan" value="com.revature.example.model" />
    <property name="hibernateProperties">
        <props>
            <prop key="hibernate.hbm2ddl.auto">create-drop</prop>
            <prop key="hibernate.dialect">org.hibernate.dialect.H2Dialect</prop>
        </props>
    </property>
</bean>
 
<bean id="dataSource"
  class="org.apache.tomcat.dbcp.dbcp.BasicDataSource">
    <property name="driverClassName" value="org.h2.Driver" />
    <property name="url" value="jdbc:h2:mem:db;DB_CLOSE_DELAY=-1" />
    <property name="username" value="user" />
    <property name="password" value="password" />
</bean>
 
<bean id="txManager"
  class="org.springframework.orm.hibernate3.HibernateTransactionManager">
    <property name="sessionFactory" ref="sessionFactory" />
</bean>
 
<bean id="persistenceExceptionTranslationPostProcessor"
  class="org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor"/>
```

One important note regarding XML-based configurations is that, unlike Java-based configurations which are type safe, in XML configurations there is no difference between pointing to a bean or pointing to a bean factory capable of creating the bean. As such, when retrieving a bean from the factory you need to do so manually. For example:
```
txManager.setSessionFactory(sessionFactory().getObject());
```

The XML file should be bootstrapped to the Spring context using an `@Configuration` annotation class:
```
@Configuration
@EnableTransactionManagement
@ImportResource({ "classpath:persistenceConfig.xml" })
public class PersistenceXmlConfig {
   //
}
```

Although these examples use an H2 database, Hibernate 3 supports a variety of SQL dialects as seen [here](https://docs.jboss.org/hibernate/orm/3.6/reference/en-US/html_single/#configuration-optional-dialects).

After configuration, you can inject the Hibernate `SessionFactory` directly as needed:
```
public abstract class HibernateExampleDAO{
 
   @Autowired
   private SessionFactory sessionFactory;
 
   ...
 
   protected Session getCurrentSession(){
      return sessionFactory.getCurrentSession();
   }
}
```


### Hibernate 5
Just as with the Hibernate 3 example, we will use Maven to compare and contrast the differences between the versions:

__Maven POM Dependences__
Hibernate Version (5.2)
```
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.4.2.Final</version>
</dependency>
```

Spring ORM Module
```
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-orm</artifactId>
    <version>5.1.6.RELEASE</version>
</dependency>
```

Database Support
```
<dependency>
    <groupId>com.h2database</groupId> 
    <artifactId>h2</artifactId>
    <version>1.4.197</version>
</dependency>
```

Spring Datasource Implementation:
```
<dependency>
    <groupId>org.apache.tomcat</groupId>
    <artifactId>tomcat-dbcp</artifactId>
    <version>9.0.1</version>
</dependency>
```

Just as with Hibernate 3, Hibernate 5 can utilize both Java and XML based configurations:

__Java Configuration__
```
@Configuration
@EnableTransactionManagement
public class PersistenceConfig {
 
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(
          {"com.revature.example.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
 
        return sessionFactory;
    }
 
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("user");
        dataSource.setPassword("password");
 
        return dataSource;
    }
 
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());
        return txManager;
    }
 
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.hbm2ddl.auto", "create-drop");
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.H2Dialect");
 
        return hibernateProperties;
    }
}
```

__XML Configuration__
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="...">
 
    <bean id="sessionFactory"
      class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
        <property name="dataSource"
          ref="dataSource"/>
        <property name="packagesToScan"
          value="com.revature.example.model"/>
        <property name="hibernateProperties">
            <props>
                <prop key="hibernate.hbm2ddl.auto">
                    create-drop
                </prop>
                <prop key="hibernate.dialect">
                    org.hibernate.dialect.H2Dialect
                </prop>
            </props>
        </property>
    </bean>
 
    <bean id="dataSource"
      class="org.apache.tomcat.dbcp.dbcp2.BasicDataSource">
        <property name="driverClassName" value="org.h2.Driver"/>
        <property name="url" value="jdbc:h2:mem:db;DB_CLOSE_DELAY=-1"/>
        <property name="username" value="user"/>
        <property name="password" value="password"/>
    </bean>
 
    <bean id="txManager"
      class="org.springframework.orm.hibernate5.HibernateTransactionManager">
        <property name="sessionFactory" ref="sessionFactory"/>
    </bean>
</beans>
```

To bootstrap XML-based configurations into the Spring Context we will once again use an `@Configuration` annotated class:
```
@Configuration
@EnableTransactionManagement
@ImportResource({"classpath:hibernate5Configuration.xml"})
public class HibernateXMLConf {
    //
}
```

With Hibernate 5 and Spring-orm module support, we can now inject the Hibernate `SessionFactory` directly at this point:
```
public abstract class HibernateExampleDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    // ...
}
```

Although this example uses an H2 database, Hibernate 5 supports a variety of SQL dialects as seen [here](https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#database-dialect).