package com.cognizant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.DaoImpl.AddDetails;
import com.cognizant.Model.Person;

@Service
public class AddDetailsService {

	@Autowired
	AddDetails addDetails;
	
	public Person add(Person person) {
		if(addDetails.add(person))
			return person;
		return null;
		
	}
}
