package com.revature;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver {

//	private static Logger log = LogManager.getLogger(Driver.class);
	private static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		System.out.println("This is a SYSO!");
		log.info("This is an info log!");
		log.error("This is an error log!");
		
		try {
			throwException();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("Exception was thrown: "+ e.fillInStackTrace() );
			
		}
	}
	
	public static void throwException() throws FileNotFoundException {
		throw new FileNotFoundException();
	}
}
