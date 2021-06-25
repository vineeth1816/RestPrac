package com.cognizant;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRespository {
	Employee[] empArr= {
			new Employee(100,"abc",25000),
			new Employee(101,"def",35000),
			new Employee(102,"ghi",45000),
			new Employee(103,"jkl",55000),
			new Employee(104,"mno",25000),
	};
	
	
	public Employee getEmployee(int id) {
		for(Employee e:empArr) {
			if(e.getId()==id) {
				return e;
			}
		}
		return null;
	}
}
