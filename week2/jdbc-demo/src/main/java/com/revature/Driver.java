package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.User;
import com.revature.services.UserService;

public class Driver {

	public static void main(String[] args) {
//		basicJdbcSetup();
		
		UserService us = new UserService();
		

		
		System.out.println("getById:" + us.getById(2));
		
		User u = new User();
		u.setUsername("Test");
		u.setPassword("testpass");
		
		us.addUser(u);
		
		List<User> users = us.getAll();
		for(User user : users) {
			System.out.println(user);
		}
	}

	public static void basicJdbcSetup() {
		/*-
		 * to setup a connection
		 * 	- url
		 * 	- username
		 * 	- password
		 */
		// set up url jdbc:postgresql://[db-url]:5432/[db-name]";
		String url = "jdbc:postgresql://demo-database.cllvqmegtmuc.us-east-1.rds.amazonaws.com:5432/postgres";
		String username = "postgres";
		String password = "p4ssw0rd";
		
		// because Connection has/can be closed, try with resources closes the resource for us
		try(Connection c = DriverManager.getConnection(url, username, password)) {
			System.out.println(c.getMetaData().getDriverName());
			
			//c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
