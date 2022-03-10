package com.revature;

import java.time.LocalDate;

import com.revature.models.BoringTask;
import com.revature.models.Task;

public class Driver {

	public final Task myTask = new Task("Question");
	public final Integer myInt = 22;
	
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
		
		// Boring Task has access to all the methods from Task
		BoringTask bt = new BoringTask();
		// once doTask has been overriden, boring task calls its own implementation of do task instead of its pant's
		bt.doTask();
		System.out.println(bt.getDueDate());
		
		System.out.println(bt);
//		System.out.println(bt.toString()); is implicitely called
		
		/*
		 * Upcasting
		 * 	[Parent class ref type] varName = new [ChildclassConstructor]();
		 * 	- only the parent class's methods are available but the child's classes implementation gets called
		 */
		Task t3 = new BoringTask();
		t3.setDescription("Something interesting");
		
		t3.doTask();

		/*
		 * Downcasting, not implicit requires explicit cast
		 * in this case tries to call a method from the child class theat doesn't exist in the parent class... leads to an exception
		 */
//		BoringTask t4 = (BoringTask) new Task();
//		t4.procrasticate();
//		t4.doTask();
		
		// Final question
		Driver d = new Driver();
		System.out.println(d.myTask);
		d.myTask.setDescription("Something else");
		System.out.println(d.myTask);
//		d.myInt = 23;
	}

}