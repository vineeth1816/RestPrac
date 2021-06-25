package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class AppController {
	@Autowired
	EmployeeRespository empRepo;
	
	
	

	@GetMapping("getEmployee/{id}/{techId}")
	public Employee getEmployee(@PathVariable int id, @PathVariable int techId) {
		Employee emp=empRepo.getEmployee(id);
		Technology r=new RestTemplate().getForObject("http://localhost:8090/getTech/"+techId, Technology.class);
		emp.setTechnology(r);
		return emp;
	}

}
