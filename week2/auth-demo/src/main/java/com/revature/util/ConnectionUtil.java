package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection con;
	
	private ConnectionUtil() {};
	
	public static Connection getConnection() throws SQLException {
		
		if(con == null || con.isClosed()) {
			con = DriverManager.getConnection(
					System.getenv("DB_URL"), 
					System.getenv("DB_USER"),
					System.getenv("DB_PASS"));
		} 
		
		return con;
	}
	
}
