Configuring Javalin is done via a Configuration lambda during creation.

```java
Javalin app = Javalin.create(config ->{     
    // pass in a lambda that describes how to create the app 
			
			config.enableCorsForAllOrigins(); 
			config.addStaticFiles("/frontend"); 
            // folder that contains html/css/js for a front end
			
		});
app.start();
        /*Routes*/

```