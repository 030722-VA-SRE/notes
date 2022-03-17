package com.revature;

import com.revature.exceptions.ItemNotFoundException;
import com.revature.models.Item;
import com.revature.services.ItemService;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		/*
		 * Allows us to interact with methods in the item service class
		 * 		- these methods interact with itempostgres to handle persistence while adding business logic
		 */
		ItemService is = new ItemService();
		
		/*-
		 * All Javalin endpoints and logic to handle those endpoints can go in the main method
		 */

		Javalin app = Javalin.create();
		app.start(8080);
		
		app.get("items", (ctx)->{
			// within HTTP handlers, leverage methods from is to handle HTTP request
		});
		
		// example of a path param
		app.get("items/{id}", (ctx) -> {
			// returns the value of pathparam of name id, converted string to int
			int id = Integer.parseInt(ctx.pathParam("id"));
			// retrieve item using Item service method
			try {
			Item item = is.getById(id);
			ctx.json(item);
			ctx.status(200);
			} catch (ItemNotFoundException e) {
				ctx.status(404);
				ctx.result("Item of id: " + id + " was not found");
				// log this to file
			}

		});

	}

}
