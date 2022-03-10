package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.revature.models.Animal;
import com.revature.models.AnimalComparator;

public class Driver {
/*
	Collection
	- is an interface that is considered the "super" interface from which every collection(List, Set, Queue) comes from
		- declares methods implemented in all concrete collection classes
			- ie:
				- add();
				- remove();
				- contains();
				- size();
	- Only work with objects (Wrapper classes are used to work with primitives)
	- Collection (I) is not to be confused with the Collections (C)
		- Collections is a class that provides util methods to work with Collection
	- Implements Iterable/ allows for a collection to be iterated over/use an iterator
	- List
		- Interface extends Collection, they can hold duplicate values
		- Concrete implementations
			- ArrayList
				- Dynamically sized array, in which elements can be added and removed
				- Arraylists leverage indexes which makes them more efficient for retrieval operations
			- LinkedList
				- Consists of a series of nodes which store data and a reference to the next node
				- LinkedList are better for insertion/deletion
	- Set
		- Interface extends Collection, they cannot hold duplicate values
		- Concrete implementations
			- HashSet
				- unordered (Can't guarantee an order)
			- TreeSet
				- ordered
					- follows "natural order"
						- specify a custom order using compator/comparable
	- Queue
		- Interface extends Collection, follows a FIFO order (First In First Out)
		- Concrete implementation:
			- Priority Queues
				- ordered by priority
			- LinkedList
				- implements both list and queue
		- additional methods
			- peek, poll...
	- Map
		- interface that does not extend Collection
			- leverages key value pair system
			- they do not implement the iterable interface so cannot use for-each loops directly on maps
		- concrete implementations
			- HashMap
			- TreeMap
Comparable
	- functional interface
	- compareTo method
		- implemented by the class itself
		- returns an integer used to define an order
	
Comparator
	- functional interface
	- compare method
	- similar to comparable but have to use a comparator object
	*/
	
	public static void main(String[] args) {
		//Arrays have a static size
		Integer[] intArr = {1, 2, 3, 4};
		String[] stringArr = {"Hello", "World", "!"};
		
		printAll(intArr);
		printAll(stringArr);
		
		// Generics: used to enforce type safety, in this case makes sure that all of the elements of the ArrayList are integers 
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.add(1);
		arrList.add(2);
		arrList.add(3);
		
		// A common way to iterate over collections is via the iterator
		Iterator<Integer> i = arrList.iterator();
		// hasNext method checks that there is another element in the collection, next() returns it
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		Set<Integer> hashSet = new HashSet<>();
		hashSet.add(1);
		hashSet.add(1);
		hashSet.add(2);
		
		Iterator<Integer> j = hashSet.iterator();
		while(j.hasNext()) {
			System.out.println(j.next());
		}
		
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		
		System.out.println(ll.peek());
		System.out.println(ll.pop());
		System.out.println(ll.pop());
		
		Map<Integer, String> hm = new HashMap<>();
		hm.put(1, "String");
		hm.put(2, "World");
		hm.put(3, "!");
		
		for(Integer h: hm.keySet()) {
			System.out.println(hm.get(h));
		}
		
		Animal a = new Animal(1, "John");
		Animal a2 = new Animal(2, "Joe");
		Animal a3 = new Animal(5, "James");
		
		System.out.println(a.compareTo(a3));
		
		ArrayList<Animal> al = new ArrayList<>();
		al.add(a2);
		al.add(a3);
		al.add(a);
		
		System.out.println(al);
		
		Collections.sort(al, new AnimalComparator());
		
		System.out.println(al);
	}
	
//	public static void printAll(Integer[] arr) {
//		for(Integer i:arr) {
//			System.out.println(i);
//		}
//	}
//	
//	public static void printAll(String[] arr) {
//		for(String i:arr) {
//			System.out.println(i);
//		}
//	}
	
	// Using generics to allow the printall method to be used for different types of objects
	public static <T> void printAll(T[] arr) {
		for(T i:arr) {
			System.out.println(i);
		}
	}
}
