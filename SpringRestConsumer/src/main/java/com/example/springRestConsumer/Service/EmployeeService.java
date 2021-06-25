package com.example.springRestConsumer.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springRestConsumer.model.Employee;
@Service
public class EmployeeService {

	public Employee giveEmployee(int id) {
		RestTemplate rt=new RestTemplate();
		Employee e=rt.getForObject("http://localhost:8080/getEmp/"+id, Employee.class);
		return e;
	}
}
