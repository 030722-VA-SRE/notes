# Spring Module - Form Input with Spring

This page details the basics of Gathering, parsing and returning data using HTML forms with Spring and JSP files.

### References
* [Spring With Forms Example - Baeldung](https://www.baeldung.com/spring-mvc-form-tutorial)
* [Spring With Forms Example - CodeJava](https://www.codejava.net/frameworks/spring/spring-mvc-form-handling-tutorial-and-example)
* [Spring Model Attribute](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/mvc.html#mvc-ann-modelattrib-methods)
* [Spring BindingResult](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/mvc.html#mvc-ann-methods)
* [Intro to JSP](https://www.javatpoint.com/jsp-tutorial)
* [Spring Form Tag](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/spring-form.tld.html#spring-form.tld.form)
* [Spring API Docs](https://docs.spring.io/spring/docs/4.0.x/javadoc-api/overview-summary.html)

## Form Input and JSP
As seen in previous examples, forms are a simple and effective way to gather input from a user. Using Spring, you can easily bind form input to a modeled POJO to easily process form requests and return an appropriate response.

To examine this first create a simple Model:
```java
public class Account {
    private long id;
    private String name;
    private String type;

    // Constructors, getters and setters...
}
```

Next, we need to create the actual form using a JSP HTML file. When establishing this file. As a refresher to Java web basics, the html views should be within a WEB-INF folder. In this example, we are not using Spring boot, so a `web.xml` file will still be required to configure the Spring Servlet. In your jsp file, make sure to include the spring framework form tag.

_accountHome.jsp_:
```java
<!-- JSTL includes, Spring Form Tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
    </head>
    <body>
        <h3>Please Enter your Account Details</h3>
        <form:form method="POST"
          action="/form-example/addAccount" modelAttribute="account">
             <table>
                <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="type">Account Type</form:label></td>
                    <td><form:input path="type"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
```

The inclusion of the Spring framework form tag is important to use the modelAttribute on the form. This modelAttribute will be used to bind our form data to our POJO through a corresponding `@ModelAttribute` annotation.

In addition to the modelAttribute, the various _path_ attributes will correspond to a getter/setter method for our model (the Account class). Note that the name here is important, as the path attribute specifically looks for a method named "get<path value>" and "set<path value>". In our case, `getId()` and `setId()`, `getName()`, etc...

The controller should look similar to examples in the past:
```java
package com.revature.controllers;

import com.revature.models.Account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView viewForm() {
        return new ModelAndView("accountHome", "account", new Account());
    }
 
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public String submit(@ModelAttribute("account")Account account, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("id", account.getId());
        model.addAttribute("name", account.getName());
        model.addAttribute("type", account.getType());
        return "accountView";
    }
}
```
Here we are using a few new concepts, Spring's `ModelAndView`, `BindingResult` and `ModelMap` objects as well as the `@ModelAttribute` annotation.

* `ModelAndView` - The Spring ModelAndView object is a class which holds both a Model and View in the web MVC framework to make it possible for a controller to return both in a single return value. Note that both Model and View are still treated as distinct entities. In the example above, we are using the following overloaded version: `public ModelAndView(String viewName, String modelName, Object modelObject)`
* `BindingResult` - The BindingResult object, as its name implies, allows for binding information to a result, specifically exceptions. This allows errors to be handled by returning specific views as opposed to a thrown exception in your application.
* `ModelMap` - The Spring ModelMap is an implementation Java Map when building Model data.
* `@ModelAttribute` - As discussed previously, the `@ModelAttribute` annotation is used to help bind Model data to our JSP, or HTML views. Specifically `@ModelAttribute` can be used in two ways on a method to populate a model with attributes. The first way, as demonstrated above, adds attributes directly to the model. Alternatively you can add attributes implicitly by returning it:
```
@ModelAttribute
public Account addAccount(@RequestParam String id) {
    return accountCreator.createAccount(id);
}
```
The method used depends on your current needs.

Finally, we should create two more JSPs to handle errors and view our model:
_error.jsp_:
```
<html>
    <head>
    </head>
 
    <body>
        <h3>Oops, and Error Occurred!</h3>
        <table>
            <tr>
                <td><a href="account">Go Back</a></td>
            </tr>
        </table>
    </body>
 
</html>
```

_accountView.jsp_:
```
<body>
    <h2>New Account Overview</h2>
    <table>
        <tr>
            <td>ID :</td>
            <td>${id}</td>
        </tr>
        <tr>
            <td>Name :</td>
            <td>${name}</td>
        </tr>
        <tr>
            <td>Account Type :</td>
            <td>${type}</td>
        </tr>
    </table>
</body>
```
