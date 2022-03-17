package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Item;
import com.revature.util.ConnectionUtil;

public class ItemPostgres implements ItemDao {

	@Override
	public Item getItemById(int id) {
		String sql = "select * from items where id = ?;";
		Item item = null;
		// retrieving a Connection to the db from the ConnectionUtil class
		// try with resources is going to close our connection at the end of the try block
		try (Connection c = ConnectionUtil.getConnection()) {
			// creating a prepared statement using that connection
			PreparedStatement ps = c.prepareStatement(sql);
			// parameterizing the sql statement with the id that we are looking for
			ps.setInt(1, id);
			
			// Executing the query from the ps, and assigning the db's query result to a result set
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				item = new Item();
				item.setId(rs.getInt("id"));
				item.setPrice(rs.getDouble("price"));
				item.setType(rs.getString("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// if an item of that id is found, returns that item, otherwise returns null
		return item;
	}

}
