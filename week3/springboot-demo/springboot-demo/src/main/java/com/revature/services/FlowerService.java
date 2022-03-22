package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.revature.models.Flower;

@Service
@Scope("prototype") // sets type as singleton, by default the scope is singleton
public class FlowerService {

	/*-
	 * @Autowired
	 * private Scanner scan;
	 */

	private List<Flower> flowers;
	
	// Mocking data persistence for demo's sake
	public FlowerService() {
		flowers = new ArrayList<>();
		Flower a = new Flower();
		a.setId(0);
		a.setColor("blue");
		a.setType("Mahipal");
		Flower b = new Flower();
		b.setId(1);
		b.setColor("green");
		b.setType("Henry");
		
		flowers.add(a);
		flowers.add(b);
		
	}
	
	public List<Flower> getFlowers(){
		return flowers;
	}
	
	public List<Flower> getFlowersByColor(String color){
		List<Flower> filteredList = new ArrayList<>();
		/*-
		 * ie:
		 * 	- getFlowersByColor("blue");
		 * 	- return should be a list of only flowers with color being blue
		 * 
		 * creating a new array list for result
		 * go through list
		 * 	- if flower in list has x color, add to filteredlist
		 * 
		 * return the filtered list
		 */
		for(Flower f:flowers) {
			if(f.getColor().equals(color)) {
				filteredList.add(f);
			}
		}
		return filteredList;
	}
	
	public Flower getFlowerById(int id) {
		Flower f = null;
		for(Flower fl : flowers) {
			if(fl.getId() == id) {
				f = fl;
			}
		}
		return f;
	}
	
	public int addFlower(Flower flower) {
		flower.setId(flowers.size());
		flowers.add(flower);
		return flower.getId();
	}
}
