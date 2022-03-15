package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// to retrieve a connection to the database
public class ConnectionUtil {

	// reuse this connection instead of creating more connections to the database
	private static Connection con;

	public static Connection getHardCodedConnection() throws SQLException {
		// set up url jdbc:postgresql://[db-url]:5432/[db-name]";
		String url = "jdbc:postgresql://demo-database.cllvqmegtmuc.us-east-1.rds.amazonaws.com:5432/postgres";
		String username = "postgres";
		String password = "p4ssw0rd";

		// if con exists, return con, else instantiate con
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		}
		return con;
	}
	
	
	// use gitignore to prevent file from being pushed to github
	public static Connection getConnectionFromFile() throws IOException, SQLException {
		// to load url, username, password
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream("creds.properties"));
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		}
		return con;
	}
	
	public static Connection getConnectionFromEnv() throws SQLException {
		/*-
		 * search for Edit the System environment variables
		 * 	- click on environment variables
		 * 	- under System variables, click new
		 * 	- enter a variable name, and its value
		 * 		- ie: DB_URL, [url_value]
		 * 	- press ok
		 * 
		 * NOTE: YOU MIGHT HAVE TO RESTART STS FOR YOUR NEW ENVIRONMENT VARIABLES TO LOAD!
		 */
		String url = System.getenv("DB_URL");
		String username = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");
		
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		}
		return con;
	}
}
