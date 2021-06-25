package com.cognizant;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@RestController
public class AppController {
	@Autowired
	EmployeeRespository empRepo;
	@Autowired
	DiscoveryClient discoveryClient;
	
	

	@GetMapping("getEmployee/{id}/{techId}")
	@HystrixCommand(fallbackMethod ="handleError")
	public Employee getEmployee(@PathVariable int id, @PathVariable int techId) {
		Employee emp=empRepo.getEmployee(id);

		
		List<ServiceInstance> list=discoveryClient.getInstances("TECHSERVICE");
		
		ServiceInstance serviceInstance=list.get(0);
		
		java.net.URI uri=serviceInstance.getUri();
		Technology tech=new RestTemplate().getForObject(uri+"/getTech/"+techId, Technology.class);
		emp.setTechnology(tech);
		return emp;
	}
	
	public Employee handleError(@PathVariable int id,@PathVariable int techId) {
		return new Employee(0,"aaa",1000);
	}
	
	

}
