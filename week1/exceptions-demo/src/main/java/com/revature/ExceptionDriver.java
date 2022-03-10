package com.revature;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionDriver {

	public static void main(String[] args) {
		System.out.println("Beginning of main method");
		
		// Arithmetic exception, runtime exception
		try {
		int i = 1/0;
		} catch (ArithmeticException e) {
			System.out.println("Some handling behavior for Arithmetic exception");
		} catch (Exception e) {
			System.out.println("Some generic handling behavior");
		}
		
		// OutOfMemoryError: do not try to recover from
//		ArrayList<Integer> al = new ArrayList<>();
//		int i = 1;
//		while(true) {
//			al.add(i);
//			i++;
//		}
		
		ExceptionDriver ed = new ExceptionDriver();
		Scanner sc = new Scanner(System.in);
		try {
			
			ed.throwException();
		} catch (Exception e) {
			// handling behavior is to print the stack trace
			e.printStackTrace();
			// how to skip finally block
//			System.exit(0);
			// log those exceptions to file
		} finally {
			sc.close();
			// Always execute?
		}
		
		// try-with resources, closes resources declared automatically
		try(Scanner scan = new Scanner(System.in)){
			
		}
		System.out.println("End of the main method");
	}
	
	// throws: assumes that exception will be handled by calling method
	public void throwException() throws FileNotFoundException{
		throw new FileNotFoundException();
	}

}
