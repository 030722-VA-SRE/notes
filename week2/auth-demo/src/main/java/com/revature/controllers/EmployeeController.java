package com.revature.controllers;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.services.AuthService;
import com.revature.services.EmployeeService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class EmployeeController {

	private static EmployeeService es = new EmployeeService();
	private static AuthService as = new AuthService();

	/*
	 * getEmployees will be used to handle several behaviors at /employees using
	 * query params - /employees - return all employees -
	 * /employees?username=[value] - return employee with a specific username -
	 * /employees?manager-id=[value] - return all employees with a specific manager
	 * id
	 */
	public static void getEmployees(Context ctx) {

		String token = ctx.header("Authorization");

		if (!as.checkPermission(token, Role.ADMIN, Role.MANAGER)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}

		// retrieving query param for username or null if it doesn't exist
		String username = ctx.queryParam("username");
		// retrieving query param for manager-id or null if it doesn't exist
		String man_id = ctx.queryParam("manager-id");

		// if a query param for username has been passed in, execute retrieve by
		// username behavior
		if (username != null) {
			Employee e = es.getEmployeeByUsername(username);

			if (e != null) {
				ctx.json(e);
				ctx.status(HttpCode.OK);
			} else {
				ctx.status(HttpCode.NOT_FOUND);
			}
			// if a query param for manager id has been passed in, execute retrieve by
			// manager id behavior
		} else if (man_id != null && !man_id.isBlank()) {
			int id = Integer.parseInt(man_id);

			List<Employee> employees = es.getEmployeesByManager(id);

			ctx.json(employees);
			ctx.status(HttpCode.OK);
			// if none is applicable, return all users
		} else {
			List<Employee> employees = es.getEmployees();

			ctx.json(employees);
			// implicitely Javalin sets the status code to 200
			ctx.status(HttpCode.OK);
		}
	}

	public static void getManagers(Context ctx) {

		String token = ctx.header("Authorization");

		if (!as.checkPermission(token, Role.ADMIN)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}

		List<Employee> employees = es.getManagers();

		ctx.json(employees);
		ctx.status(HttpCode.OK);

	}

	public static void registerEmployee(Context ctx) {
		/*
		 * add employee requires an Employee Object with a name, username, password
		 * 
		 * HTTP request - version - headers - body - need to have name, username,
		 * password - url - localhost:8080/employees - http verb/method... - POST
		 */

		/*
		 * Object mapper converts JSON object to Java Object mapped to the Employee
		 * class - fields the the JSON object that match fields in the Employee java
		 * class will be mapped accordingly
		 */
		Employee newEmp = es.addEmployee(ctx.bodyAsClass(Employee.class)); // should return new employee with id if
																			// successful, or null otherwise

		if (newEmp == null) {
			ctx.status(HttpCode.BAD_REQUEST);
		} else {
			ctx.status(HttpCode.CREATED);
		}

	}

	public static void getEmployeeById(Context ctx) {

		String token = ctx.header("Authorization");

		if (!as.checkPermission(token, Role.ADMIN, Role.MANAGER)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}

		// pathParam("nameOfPathParam");
		int id = Integer.parseInt(ctx.pathParam("id"));

		Employee e = es.getEmployeeById(id);

		if (e != null) {
			ctx.json(e);
			ctx.status(HttpCode.OK);
		} else {
//			ctx.status(404);
			ctx.status(HttpCode.NOT_FOUND);
		}
	}

	public static void updateEmployeeInfo(Context ctx) {

		String token = ctx.header("Authorization");

		if (!as.checkPermission(token, Role.ADMIN, Role.MANAGER, Role.BASIC_EMPLOYEE)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}

		int id = Integer.parseInt(ctx.pathParam("id"));

		Employee e = ctx.bodyAsClass(Employee.class);

		e.setId(id);

		if (es.updateEmployeeInfo(e)) {
			ctx.status(HttpCode.OK);
		} else {
			ctx.status(400);
		}
	}

	public static void updateEmployeeInfoAdmin(Context ctx) {

		String token = ctx.header("Authorization");

		if (!as.checkPermission(token, Role.ADMIN)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}

		int id = Integer.parseInt(ctx.pathParam("id"));

		Employee e = ctx.bodyAsClass(Employee.class);

		e.setId(id);

		if (es.updateEmployeeInfoAdmin(e)) {
			ctx.status(HttpCode.OK);
		} else {
			ctx.status(400);
		}
	}

}
