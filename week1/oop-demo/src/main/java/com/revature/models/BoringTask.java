package com.revature.models;

import java.time.LocalDate;

public class BoringTask extends Task{

	public BoringTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void procrasticate() {
		setDueDate(LocalDate.now().plusDays(1));
	}
	
	@Override
	public void doTask() {
		System.out.println("Doing " + getDescription() + " slowly...");
	}
}
