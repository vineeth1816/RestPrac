package com.cognizant.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.Dao.AddDetailsDao;
import com.cognizant.Model.Person;
@Component
public class AddDetails implements AddDetailsDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Boolean add(Person p) {
		int i=jdbcTemplate.update("INSERT INTO details VALUES(?,?)", p.getId(),p.getName());
		if(i>0)
			return true;
		
		return false;
	}

}
