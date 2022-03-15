package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

// class to interact with postgres database
public class UserPostgres implements UserDao{

	@Override
	public int createUser(User user) {
		// if -1 is returned, no record was created
		int genId = -1;
		// returns the generated id for that user
		String sql = "insert into users(username, password) values(?, ?) returning id;";
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			// setting the ? values in the sql prepared statement
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			// executing the prepared statement which returns the generated id in the result set
			ResultSet rs = ps.executeQuery();
			
			// if successful retrieves the generated id for the new user
			if(rs.next()) {
				genId = rs.getInt("id");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return genId;
	}

	@Override
	public List<User> getUsers() {
		String sql = "select * from users;";
		List<User> users = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				User newUser = new User();
				newUser.setId(rs.getInt("id"));
				newUser.setUsername(rs.getString("username"));
				newUser.setPassword(rs.getString("password"));
				
				users.add(newUser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public User getUserById(int id) {
//		String sql = "select * from users where id = " + id + ";"; vulnerable to SQL injection
		String sql = "select * from users where id = ?;";
		User user = null;
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id); // this refers to the 1st ? in the sql String
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		String sql = "select * from users where id = " + username + ";";
		// username = "0; DROP TABLE USERS;"
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
