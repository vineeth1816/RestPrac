package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AppController {
	
	
	@Autowired
	TechnologyRepository techRepo;
	
	@GetMapping("getTech/{id}")
	public Technology getTech(@PathVariable int id) {
		return techRepo.getTechnology(id);
		
	}

	

}
