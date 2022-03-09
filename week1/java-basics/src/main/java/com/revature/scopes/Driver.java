package com.revature.scopes;

public class Driver {

	public String name;
	
	public static String s = "SomeString";
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		
//		System.out.println(i); i is outside of the block scope where is was declared
		Driver d = new Driver();
		
		d = d.getMeD();
		
		System.out.println(d.getMeI()); // returns 9 and the variable i is discarded
		System.out.println(s);
//		Driver.main(args);
//		System.out.println(i); i was declared in the getMeI method which was popped off the stack
		
		
		// String pool example
		String s = "hello";
		String s1 = "hello";
		String s2 = new String("hello");
		
		// Passby value
		int x = 3;
		d.incrementX(x);
		
		System.out.println(x);
		
		d.changeName(d);
		
		System.out.println(d.name);
	}
	
	public int getMeI() {
		int i = 9;
		Driver d2 =new Driver();
		d2.name = "Kevin";
		return i;
	}
	
	// accessMod returnType
	public Driver getMeD() {
		int i = 9;
		Driver d2 =new Driver();
		d2.name = "Kevin";
		return d2;
	}
	
	public void incrementX(int j) {
		j++;
	}
	
	public void changeName(Driver d) {
		d.name = "Aaron";
	}
}
