package com.revature.models;

import java.util.Comparator;

public class AnimalComparator implements Comparator<Animal>{

	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.getName().length() - o2.getName().length();
	}

}
