package com.revature;

import com.revature.exceptions.WeHateSevenException;

public class Calculator {
	
	/*
	 * 	Should be able to
	 * 		- give secret to the universe
	 * 		- add
	 * 			- if the result is 7 throw a WeHate7Exception 
	 * 		- subtract
	 * 		- divide
	 * 			- if dividing by 0 throw exception
	 * 		- multiply
	 * 		- sum
	 */

	public double add(double x, double y) {
		double result = x + y;
		if (result == 7) {
			throw new WeHateSevenException();
		}
		return result;
	}
	
	public double subtract(double x, double y) {
		return 0;
	}
	
	public double multiple(double x, double y) {
		return 0;
	}
	
	public double divide(double x, double y) {
		return 0;
	}
	
	public double sum(double... x) {
		return 0;
	}
}
