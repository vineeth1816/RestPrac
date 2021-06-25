package com.cognizant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	
	@GetMapping("getEmployee")
	public Employee getEmployee() {
		return new Employee(100,"abc",25000);
	}
}
