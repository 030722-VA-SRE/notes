package com.revature.daos;

import java.util.List;

import com.revature.models.Task;

public interface TaskDao {

	public List<Task> getAllTasks();
	public List<Task> getTasksByUserId(int userId);
	public List<Task> getTasksByCompletion(boolean isCompleted);
	public Task getTaskById(int id);
	public int createTask(Task task);
	public boolean updateTask(Task task);
	public boolean deleteTaskById(int id);
}
