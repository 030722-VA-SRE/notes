package com.revature.interfaces;

import java.io.Serializable;

// interfaces can EXTEND one another
public interface Doable extends Serializable{

	// fields in interfaces have to be public static and final: it's a constant
	public static final int ANSWER_TO_LIFE = 42;
	
	// abstract implicitely, meaning abstract even if not declared abstract
	void doo();
	
	//default allows for concrete methods in an interface
	default void something() {
		System.out.println("This is from the interface!");
	}
}
