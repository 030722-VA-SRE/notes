To accept path parameters in a route you put ':paramName' in the path argument. You can get the value of path parameters from the context object. Note that path params come in as a String type. Additionally, routes with parameters are considered a different path. This means that
a different handler can be used for each one. Query parameters are *NOT* specified in the route.
You can add as many query or path parameters as you want.

```java

        // GET /associates/19
		app.get("/associates/:id", (ctx)->{
			String id = ctx.pathParam("id");
            System.out.println(id)// 19
            /*Handler Code*/
		});

          // GET /associates?fname=Adam
		app.get("/associates", (ctx)->{
            String fname = ctx.queryParam("fname");
            System.out.println(fname) // prints Adam
			/*Handler Code*/
		});


```