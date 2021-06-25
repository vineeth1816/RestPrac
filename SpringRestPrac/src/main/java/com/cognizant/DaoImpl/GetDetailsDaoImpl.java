package com.cognizant.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.cognizant.Dao.GetDetailsDao;
import com.cognizant.Model.Person;
@Component
public class GetDetailsDaoImpl implements GetDetailsDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Person getDetails(int id) {
		Person p;
		p=jdbcTemplate.query("SELECT * FROM details WHERE id=?", new ResultSetExtractor<Person>() {

			@Override
			public Person extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				Person p1=new Person();
				p1.setId(rs.getInt("id"));
				p1.setName(rs.getString("name"));
				return p1;
			}
			
		}, id);
		return p;
	}
	

}
