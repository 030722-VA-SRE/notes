When writing a Javalin app your routes must be matched to handlers. Handlers are lambdas that
will be invoked when an HTTP request is sent to that route. The Javalin Handler lambda has one
argument often written as ctx. The ctx argument is a Object of type Context. This context object
has all the information pertaining to that HTTP request. It also contains an HTTP response object and HTTP Request object. You will rarely use the HTTP Response or Request objects directly. The Context object has many useful methods that abstract away interacting with them.

```java
 Handler myHandler = (ctx)->{
        /*Handler Code*/
	};

```


Get request body

```java
 Handler myHandler= (ctx)->{
        String body = ctx.body();
	};

```

Set response body and status code

```java
 Handler myHandler= (ctx)->{
        String hello = "Hello"
        ctx.status(200)
        ctx.result(hello); // 'hello' back as the http response body
	};

```


