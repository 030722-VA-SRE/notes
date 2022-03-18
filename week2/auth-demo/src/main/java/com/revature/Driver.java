package com.revature;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import com.revature.controllers.AuthController;
import com.revature.controllers.EmployeeController;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		// Creating an instance of javalin and starting on port 8080
		Javalin app = Javalin.create((config) -> {
			config.enableCorsForAllOrigins();
			/*
			 * Enables CORS: Cross Origin Resource Sharing - protective mechanism built into
			 * most browsers - restricts resources to be only be allowed by webpages on the
			 * same domain
			 */
			config.defaultContentType = "application/json";
		});
		app.start();

		/*
		 * Headers to tell the browser that the Authorization header that we're using for our "token" 
		 * in the Response body is safe to use, otherwise the browser may not accept it
		 */
		app.before(ctx -> {
		    ctx.header("Access-Control-Allow-Headers", "Authorization");
		    ctx.header("Access-Control-Expose-Headers", "Authorization");
		});
		
		app.routes(() -> {
			// /employees
			path("employees", () -> {
				get(EmployeeController::getEmployees);
				post(EmployeeController::registerEmployee);
				
				// use brackets to indicate path param name
				// /employees/{id}
				path("managers", () -> {
					get(EmployeeController::getManagers);
				});
				path("{id}", () -> {
					get(EmployeeController::getEmployeeById);
					put(EmployeeController::updateEmployeeInfo);
					
					// /employees/{id}/admin
					path("admin", () -> {
						put(EmployeeController::updateEmployeeInfoAdmin);
					});
				});
			});
			// /auth
			path("auth", () ->{
				post(AuthController::login);
			});
		});
	}

}
