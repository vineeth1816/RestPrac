package com.example.springRest.model;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRepo {
	Employee[] empAr= {
			new Employee(100,"abc",50000),
            new Employee(200,"def",45000),
            new Employee(300,"mno",35000),
            new Employee(400,"pqr",50000),
	};
	
	
	public Employee findEmp(int id) {
		for(Employee e:empAr) {
			if(e.getId()==id) {
				return e;
			}
		}
		return null;
	}

}
