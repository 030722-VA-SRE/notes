package com.revature.string;

public class StringDriver {

	public static void main(String[] args) {
		
		/*
		 * There are different ways to initialize a String
		 * 		- String literal
		 * 		- using the new keyword
		 */
		String s = "Hello World!"; // literal
		String s2 = "Hello World!";
		String s3 = new String("Hello World!");
		
		/*
		 * Comparing objects in Java:
		 * 	- == vs .equals()
		 * 		- == compares stack values, used for primitives
		 *		- .equals (if implemented properly) compares the values defined in the class
		 *				- default implementation of the method in the Object class is ==
		 */
		
		Object a = new Object();
		Object b = new Object();
		
		System.out.println("a.equals(b)" + a.equals(b));
		System.out.println("a == b " + (a == b));
		System.out.println();
		
		// s & s2 refer to the same string in the string pool because they were declared literally
		System.out.println("s & s2: " + (s==s2));
		System.out.println("s & s2: " + s.equals(s2));
		System.out.println();
		
		// s & s3 refer to different strings because s3 was created in the heap using the new keyword
		System.out.println("s & s3: " + (s==s3));
		System.out.println("s & s3: " + s.equals(s3));
		System.out.println();
		
		String s4 = "Hello "+ "World!";
		System.out.println("s & s4: " + (s==s4));
		System.out.println("s & s4: " + s.equals(s4));
		
		// intern method found a ref to "Hello World!" in the string pool and returned it
		s3 = s3.intern();
		System.out.println("s & s3: " + (s==s3));
		System.out.println("s & s3: " + s.equals(s3));
		
		/*
		 * String methods worth checking out:
		 * substring
		 * replace
		 * charAt
		 * split
		 * length
		 */
		
		StringBuilder sb = new StringBuilder(s);
		System.out.println(sb);
		/*
		 * add a char
		 * remove 2
		 * get a substring
		 */
		
		sb.reverse();
		System.out.println(sb);
		
		String formerStringBuffer = sb.toString();
				
		// Generally use StringBuilder
		StringBuffer sbuf = new StringBuffer();
		
	}
}
