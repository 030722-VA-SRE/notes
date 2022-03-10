Routing is simple. To create a route you will speciy the HTTP verb via the method. The first
parameter is the URI to listen for http requests from. Below depicts CRUD operations for 
and endpoint at /associates .

```java
	
package dev.ranieri.app;

import io.javalin.Javalin;

public class App {
	
	public static void main(String[] args) {
		
		Javalin app = Javalin.create();
        app.start();
		
        // GET all associates
		app.get("/associates", (ctx)->{
			/*Handler Code*/
		});

        // GET associate by id
		app.get("/associates/:id", (ctx)->{
			/*Handler Code*/
		});

        //POST add an associate
        app.post("/associates", (ctx)->{
			/*Handler Code*/
		});

        //PUT upsert an associate
        app.put("/associates", (ctx)->{
			/*Handler Code*/
		});

        //PUT update an associate
        app.put("/associates/:id", (ctx)->{
			/*Handler Code*/
		});

        //DELETE delete an associate
        app.delete("/associates/:id", (ctx)->{
			/*Handler Code*/
		});
		
	}
}
```