Creating a Hello World app takes a few lines of code. If you are familiar with express Javalin
is essentially the Java version. Javalin runs by executing the main method.

**Hello World**
```java
	
package dev.ranieri.app;

import io.javalin.Javalin;

public class App {
	
	public static void main(String[] args) {
		
		Javalin app = Javalin.create();

        // starts a Javlin web server at the specified port. Defaults to port 7000
		app.start(5555);
		
        // add routes to our web server
		app.get("/hello", (ctx)->{
			ctx.result("Hello World");
		});
		
	}
}
```

**Dependencies**

Setting Up Javalin is very straight forward. 
It runs on an embedded Jetty Server and there is no need to configure a Servlet Container. 
Javalin requires two dependencies.

**pom.xml**
```xml
	<dependencies>
		<dependency>
			<groupId>io.javalin</groupId>
			<artifactId>javalin</artifactId>
			<version>3.10.1</version>
		</dependency>

		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-simple</artifactId>
			<version>1.7.30</version>
		</dependency>
	</dependencies>
```
