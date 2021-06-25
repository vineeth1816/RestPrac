package com.example.springRestConsumer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springRestConsumer.Service.EmployeeService;
import com.example.springRestConsumer.model.Employee;

@Controller
public class AppController {
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/")
	public String showEmp() {
		return "showEmp";
	}
	
	
	@GetMapping("/getEmp")
	public String getEmp(@RequestParam int empId,Model model) {
		Employee e1=empService.giveEmployee(empId);
		model.addAttribute("emp",e1);
		return "showEmp";
	}
}
