package com.revature.models;

import java.time.LocalDate;

public class Task {
	
//	String description; default access modifier
	private String description;
	private float timeTaken;
	private boolean isCompleted;
	private LocalDate dueDate;
	private static int numberOfTasks;
	
	public Task() {
		super();
		dueDate = LocalDate.now().plusDays(1);
		numberOfTasks++;
	}
	
	public Task(String description) {
		this();
		this.description = description;
	}
	
	public void doTask() {
		System.out.println("Doing "+ description + "!");
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		// we use the this keyword to refer to the field "description", if we didn't we would just be referring tp the parameter being passed in
		// variable shadowing
		this.description = description;
	}

	public float getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(float timeTaken) {
		this.timeTaken = timeTaken;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		if(dueDate.isBefore(LocalDate.now())) {
			System.out.println("Quit lazing around!");
			return;
		}
		this.dueDate = dueDate;
	}

	public static int getNumberOfTasks() {
		return numberOfTasks;
	}

	public static void setNumberOfTasks(int numberOfTasks) {
		Task.numberOfTasks = numberOfTasks;
	}
	
	public void changeSomething(Task t) {
		t.description = "HAHA!";
	}

	@Override
	public String toString() {
		return "Task [description=" + description + ", timeTaken=" + timeTaken + ", isCompleted=" + isCompleted
				+ ", dueDate=" + dueDate + "]";
	}
}
