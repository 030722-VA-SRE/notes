package com.revature.garbage;

public class Driver {

	public int id;
	
	public Driver(int id) {
		this.id = id;
	}
	public static void main(String[] args) {
		Driver d = new Driver(0);
		
		// an object is eligible for garbage collection once they are no longer referenced
		for(int i = 0; i < 1000; i++) {
			d = new Driver(i);
			System.gc();
		}
	}
	
	public void finalize() {
		System.out.println(id);
	}

}
