package com.cognizant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.DaoImpl.GetDetailsDaoImpl;
import com.cognizant.Model.Person;

@Service
public class GetDetailsService {

	@Autowired
	GetDetailsDaoImpl getDetailsDaoImpl;
	
	public Person getDetails(int id) {
		return getDetailsDaoImpl.getDetails(id);
		
	}
}
