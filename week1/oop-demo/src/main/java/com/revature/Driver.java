package com.revature;

import java.time.LocalDate;

import com.revature.models.BoringTask;
import com.revature.models.Task;

public class Driver {

	public static void main(String[] args) {
		Task t1 = new Task();
		t1.setDescription("Take a nap");
		t1.doTask();
		System.out.println("due date = " + t1.getDueDate());
		
		Task t2 = new Task("Clean your room");
		t2.doTask();
		
		// Static members are traditionally called using the class name
//		System.out.println("number of task: " + Task.numberOfTasks);
	
		// Creating an object of type Object
		Object o1 = new Object();
		
		// setting the due date of a class to 10years ago might break app logic
		t2.setDueDate(LocalDate.now().minusYears(10));
		
		t1.changeSomething(t2);
		
		System.out.println(t2.getDescription());
		
		// Boring Task has access to all the methods from tasks
		BoringTask bt = new BoringTask();
		bt.doTask();
		System.out.println(bt.getDueDate());
		
		System.out.println(bt);
//		System.out.println(bt.toString()); is implicitely called
	}

}
