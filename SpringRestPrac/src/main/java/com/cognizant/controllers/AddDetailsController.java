package com.cognizant.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Model.Person;
import com.cognizant.Service.AddDetailsService;
import com.cognizant.Service.GetDetailsService;



@RestController
public class AddDetailsController {

	@Autowired
	AddDetailsService addDetailsService;
	
	@Autowired
	GetDetailsService getDetailsService;
	
	@PostMapping("adddetails")
	public Person addDetails(@RequestBody Person p) {
		return addDetailsService.add(p);
	}
	
	@GetMapping("getDetails/{id}")
	public Person getDetails(@PathVariable int id) {
		return getDetailsService.getDetails(id);
	}
}
