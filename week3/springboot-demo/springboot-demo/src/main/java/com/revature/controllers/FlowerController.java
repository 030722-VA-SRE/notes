package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Flower;
import com.revature.services.FlowerService;

@Controller
//@RestController - Adds @Response Body to all Request mapping methods
@RequestMapping("/flowers")
public class FlowerController {

	// Example of a dependency in Java, ie: an object required for the class to
	// function properly
//	@Autowired
	private FlowerService fs; // = new FlowerService();
	// fs = new FlowerService();

	@Autowired
	public FlowerController(FlowerService fs) {
		this.fs = fs;
	}

//	@RequestMapping(method=RequestMethod.GET, path="/flowers")
	@GetMapping
	public ResponseEntity<List<Flower>> getAllFlowers(@RequestParam(name = "color", required = false) String color) {
		if (color != null) {
			return new ResponseEntity<>(fs.getFlowersByColor(color), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(fs.getFlowers(), HttpStatus.OK);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Flower> getFlowerById(@PathVariable("id") int id) {
		return new ResponseEntity<>(fs.getFlowerById(id), HttpStatus.OK);
	}

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World!";
	}

	@PostMapping
	public ResponseEntity<String> createFlower(@RequestBody Flower flower) {
		if (fs.addFlower(flower) > -1) {
			return new ResponseEntity<>("created", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Failed to create flower.", HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
		}

	}
//	@Autowired
//	public void setFs(FlowerService fs) {
//		this.fs = fs;
//	}

}
