package com.revature;

import java.util.Scanner;

public class ScannerDriver {
	
	// Instantiate a scanner object and pass in System in
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		System.out.println("Hello World!");
//		System.out.println("What's your name?");
//		
//		// captures the line provided by the user
//		String name = sc.nextLine();
//		
//		System.out.println("Hello " + name);
//		System.out.println("Pick a number:");
//		
////		int num = sc.nextInt();
////		sc.nextLine(); // this sc.nextLine() flushes/grabs the leftovers from the previous input capture
//		String number = sc.nextLine();
//		 //some validation
//		int num = Integer.parseInt(number);	
//		System.out.println("You picked " + num);
		
//		ScannerDriver.loginScreen();
		
		ScannerDriver.menu();
		// Please close your resources people
		sc.close();
		
	
	}
	
	public static void loginScreen() {
		String uname = "admin";
		String pass = "pass";
		
		System.out.println("Please enter your username:");
		String username = sc.nextLine();
		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		if(uname.equals(username) && pass.equals(password)) {
			System.out.println("You're logged in.");
		} else {
			System.out.println("Not quite.");
		}
	}
	
	/*
	 * Example of a menu that gives a user multiple options:
	 * 		- 1: get a random number
	 * 		- 2: Using StringBuffer, reverse a word of the user's choice
	 * 		- 3: exit the program
	 * This menu repeats until the user decides to exit.
	 */
	
	public static void menu() {
		boolean run = true;
		while(run) {
			System.out.println("Please select an option:\n"
								+ "1: to retrieve a random number\n"
								+ "2: to reverse a word\n"
								+ "3: to exit the program");
			String input = sc.nextLine();
			switch(input) {
			case "1": 
				System.out.println("Here's a random number: " + Math.round(Math.random() * 100));
				break;
			case "2":
				System.out.println("Please enter a word:");
				StringBuffer sb = new StringBuffer(sc.nextLine());
				System.out.println("Here is your reversed word: " + sb.reverse());
				break;
			case "3":
				run = false;
				System.out.println("Goodbye.");
				break;
			default:
				System.out.println("Invalid option.");
			}
			
		}
	}
}
