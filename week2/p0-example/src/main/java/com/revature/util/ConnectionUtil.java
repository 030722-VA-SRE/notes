package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	// Making this connection a singleton to be returned to any method querying the database, aka reusing the same object
	private static Connection con;
	
	// returns a connection if it exists/is open, otherwise creates a connection to the database
	public static Connection getConnection() throws SQLException {
		
		String url = System.getenv("DB_URL_JAVALIN");
		String username = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");
		
		if(con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		}
		return con;
	}
}
