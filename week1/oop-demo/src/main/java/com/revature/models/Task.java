package com.revature.models;

import java.time.LocalDate;
import java.util.Objects;

//public abstract class Task {
	public class Task extends OgTask{
@Override
		public int hashCode() {
			return Objects.hash(description, dueDate, isCompleted, someString, timeTaken);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Task other = (Task) obj;
			return Objects.equals(description, other.description) && Objects.equals(dueDate, other.dueDate)
					&& isCompleted == other.isCompleted && Objects.equals(someString, other.someString)
					&& Float.floatToIntBits(timeTaken) == Float.floatToIntBits(other.timeTaken);
		}

	//	String description; default access modifier
	private String description;
	private float timeTaken;
	private boolean isCompleted;
	private LocalDate dueDate;
	private static int numberOfTasks;
	private final String someString;
	
	public Task() {
		super();
		dueDate = LocalDate.now().plusDays(1);
		numberOfTasks++;
		this.someString = "";
	}
	
	public Task(String description) {
		this();
		this.description = description;
	}
	
	public void doTask() {
		System.out.println("Doing "+ description + "!");
	}
	
	public void doTask(int number) {
		for(int i = 0; i < number; i++) {
			System.out.println("Doing "+ description + "!");
		}
	}

	// if methods have the same type and number, doesn't know which one is called
//	public void doTask(int num) {
//		for(int i = 0; i < num; i++) {
//			System.out.println("Doing "+ description + "!");
//		}
//	}
	
	public void doTask(String something) {
		System.out.println("Doing "+ something + "!");
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

	@Override
	public void run() {
		System.out.println(description + " is running away from you!");
	}

	@Override
	public void doo() {
		// TODO Auto-generated method stub
		
	}
}
