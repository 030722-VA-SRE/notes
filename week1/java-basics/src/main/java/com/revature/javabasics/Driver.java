package com.revature.javabasics;

// This is a single line comment!

/*
 * This is a multiline comment!
 * Naming conventions: (no reserved keyword)
 * 		- reverse url for package name (all lower case)
 * 		- PascalCase for ClassName/InterfaceName
 * 		- camelCase for methodName/variableName ($, _, ...)
 * 			- * constants are ALLCAPS
 * 
 * NOTE: name of your public class needs to match the name of your file
 */

public class Driver {
	
	public int id;
	public String name;
	
	public Driver() {
		System.out.println("the Driver() constructor has been called!");
		id = 22;
		name = "default name";
	}
	public Driver(String name) {
		/*
		 * the "this" keyword is a reference to the current instance of a class
		 * this() calls the noargs constructor
		 */
		this();
		System.out.println("the Driver(String name) constructor has been called!");
		this.name = name;
	}	
	public Driver(int id, String name) {
		this(name);
		System.out.println("the Driver(int id, String name) constructor has been called!");
		this.id = id;
	}
	
//	<======= method signature ===========>
	public static void main(String[] args) {
		System.out.println("Hello world from STS!");
		// Command line arguments can be added via Run Configuration => Arguments => Program Arguments
		if(args.length > 0) {
			for(int i = 0; i < args.length; i++) {
				System.out.println(args[i]);
			}
		}
		
		// primitive types
		byte byteVar = 0; // 1 byte
		short shortVar = -1; // 2 bytes, both declaration and initialization
		int intVar; // 4 bytes, variable declaration
		intVar = 100; // variable initialization
		long longVar = 42; // 8 bytes
		
		float floatVar = 1.1f; // 4 bytes
		double doubleVar = 22.22; // 8 bytes
		
		char charVar = 'A'; // 2 bytes

		boolean boolVar = false; // JVM dependent
		
//		boolVar = intVar; doesn't work because int and boolean are not compatible type
		
		intVar = shortVar; // within the same "type" of variables and we're just allocating more memory
		
//		intVar = floatVar; different types, doesn't work
//		floatVar = doubleVar; this doesn't work by default because going from bigger to smaller
		
		charVar = 0;
		
		Byte byteWrap = byteVar;
		Integer intWrap = intVar;
		Character charWrap = charVar;
		
		Object o1 = new Object();
		// new is calling the Driver constructor defined above
		Driver d1; // Declaring a reference variable of type Driver 
		d1 = new Driver();
		// d1 is a referenceType
		
		// Initialization
		int i;
		
		System.out.println("d1's id= " + d1.id);
		System.out.println("d1's name= " + d1.name);
		
					// JVM looks for a constructor for the Driver class that takes in a String
		Driver d2 = new Driver(5, "Kevin");
		System.out.println("d2's id= " + d2.id);
		System.out.println("d2's name= " + d2.name);
		
//		String s = d2.sayHello(); sayHello does not return anything
		String s = d2.sayStringHello();
		String s1 = d2.saySomething("Else");
		
		System.out.println(s1);
		
		/*
		 * Control flow statements (conditionals/loops):
		 * 		- if/else, if
		 * 		- switch
		 * 		- while
		 * 		- for
		 * 		- do/while
		 */
		
		int x = 2;
		int y = 5;
		int z = 7;
		
		/*
		 * && or || exhibit shortcircuiting behavior: it won't execute the second expression if the first part is enough
		 */
		if(x == 5 && y > 3) {
			System.out.println("x == 5 & y > 3");
		} else {
			System.out.println("Doesn't match");
		}
		System.out.println();
		System.out.println();
		System.out.println();
		/*
		 * case 3 executes due to fall through behavior, since break is missing in case 2
		 */
		switch(x) {
		case 1:
			System.out.println("x is 1");
			break;
		case 2:
			System.out.println("x is 2");
//			break;
		case 3:
			System.out.println("x is 3");
			break;
		default:
			System.out.println("None of the above.");
		}
		
		while(x < 10) {
			System.out.println(x);
			x++;
		}
		System.out.println();
		System.out.println();
		do {
			System.out.println(x);
			x++;
		} while(x <10);
		
		for(int ij = 0; ij < 10; ij++) {
			System.out.println(ij);
		}
		
		/*
		 * Arrays
		 * 	- linear contiguous containers of a same datatype
		 * 		- can be either for primitives or reference types
		 * 		- contiguous blocks in memory
		 * 			- fixed size
		 * 	- Elements in an array can accessed using indexes
		 * 		- starts at 0
		 */
		
		int[] intArr = new int[5]; // initializing an array of size 5
		int []intArr1 = new int[5];
		int intArr2[] = new int[5];
		
		int[] intArr3 = {0, 1, 2, 3};
		
		for(int j = 0; j < intArr.length; j++) {
			System.out.println(intArr[j]);
		}
		
		// enhanced for loop/for each loop returns the element itself rather than the index
		for(int in : intArr3) {
			System.out.println(in);
		}
	}
	
	/*
	 * [access-mod] [non-access mods] [returnType/void] methodName([parameters if any])
	 */
	public void sayHello() {
		System.out.println("Hello");
	}
	
	public String sayStringHello() {
		return "Hello";
	}
	
	public String saySomething(String something) {
		return something;
	}
	
	public String saySomething(int i, String something) {
		return something + i;
	}
}


