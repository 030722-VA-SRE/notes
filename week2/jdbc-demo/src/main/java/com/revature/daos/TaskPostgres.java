package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Task;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class TaskPostgres implements TaskDao {

	@Override
	public List<Task> getAllTasks() {
		String sql = "select * from tasks;";
		List<Task> tasks = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				Task newTask = new Task();
				newTask.setId(rs.getInt("id"));
				newTask.setDescription(rs.getString("description"));
				newTask.setCompleted(rs.getBoolean("is_completed"));

				/*-
				 *  to handle incompatible types of ref in database and Java Obj
				 *  	- just set a "dummy object" with just the id set for
				 */
				User userAssigned = new User();
				userAssigned.setId(rs.getInt("user_assigned_id"));
				newTask.setUserAssigned(userAssigned);

				tasks.add(newTask);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public List<Task> getTasksByUserId(int userId) {
		String sql = "select * from tasks where user_assigned_id = ?;";
		List<Task> tasks = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Task newTask = new Task();
				newTask.setId(rs.getInt("id"));
				newTask.setDescription(rs.getString("description"));
				newTask.setCompleted(rs.getBoolean("is_completed"));

				User userAssigned = new User();
				userAssigned.setId(rs.getInt("user_assigned_id"));
				newTask.setUserAssigned(userAssigned);

				tasks.add(newTask);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public List<Task> getTasksByCompletion(boolean isCompleted) {
		String sql = "select * from tasks where is_completed = ?;";
		List<Task> tasks = new ArrayList<>();

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setBoolean(1, isCompleted);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Task newTask = new Task();
				newTask.setId(rs.getInt("id"));
				newTask.setDescription(rs.getString("description"));
				newTask.setCompleted(rs.getBoolean("is_completed"));

				User userAssigned = new User();
				userAssigned.setId(rs.getInt("user_assigned_id"));
				newTask.setUserAssigned(userAssigned);

				tasks.add(newTask);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public Task getTaskById(int id) {
		String sql = "select * from tasks where id = ?;";
		Task newTask = new Task();

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				newTask = new Task();
				newTask.setId(rs.getInt("id"));
				newTask.setDescription(rs.getString("description"));
				newTask.setCompleted(rs.getBoolean("is_completed"));

				User userAssigned = new User();
				userAssigned.setId(rs.getInt("user_assigned_id"));
				newTask.setUserAssigned(userAssigned);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newTask;
	}

	@Override
	public int createTask(Task task) {
		String sql = "insert into tasks(description, user_assigned_id) values (?,?)returning id;";
		int generatedId = -1;

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, task.getDescription());
			ps.setInt(2, task.getUserAssigned().getId());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				generatedId = rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return generatedId;
	}

	@Override
	public boolean updateTask(Task task) {
		String sql = "update tasks set description = ?, is_completed = ?, user_assigned_id = ? where id = ?;";
		int rowsChanged = -1;

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, task.getDescription());
			ps.setBoolean(2, task.isCompleted());
			ps.setInt(3, task.getUserAssigned().getId());
			ps.setInt(4, task.getId());

			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rowsChanged < 1) {
			return false;
		}

		return true;
	}

	@Override
	public boolean deleteTaskById(int id) {
		String sql = "delete from tasks where id = ?;";
		int rowsChanged = -1;

		try (Connection c = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id);

			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rowsChanged < 1) {
			return false;
		}

		return true;
	}

}
