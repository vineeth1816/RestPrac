package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Employee;
import com.cognizant.model.EmployeeRespository;
import com.cognizant.model.Technology;
import com.cognizant.model.TechnologyRepository;

@RestController
public class AppController {
	@Autowired
	EmployeeRespository empRepo;
	
	@Autowired
	TechnologyRepository techRepo;

	@GetMapping("getEmployee/{id}/{techId}")
	public Employee getEmployee(@PathVariable int id, @PathVariable int techId) {
		Technology tech= techRepo.getTechnology(techId);
		Employee emp=empRepo.getEmployee(id);
		emp.setTechnology(tech);
		return emp;

	}

}
