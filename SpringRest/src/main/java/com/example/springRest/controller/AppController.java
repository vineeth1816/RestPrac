package com.example.springRest.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springRest.model.Employee;
import com.example.springRest.model.EmployeeRepo;

@RestController
public class AppController {

	@Autowired
	EmployeeRepo e;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/getEmp/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> getEmp(@PathVariable int id) {

		Employee e1 = jdbcTemplate.query("SELECT * FROM employee where id=?", new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setSalary(rs.getInt("salary"));
				return e;
			}

		}, id);

		if (e1 == null)
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		else
			return new ResponseEntity(e1, HttpStatus.OK);

	}

	@PostMapping("/registerEmp")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<Object> getEmp(@RequestBody Employee employee) {

		int flag = 0;
		try {
			flag = jdbcTemplate.update("insert into employee values(?,?,?)", employee.getId(), employee.getName(),
					employee.getSalary());
			return new ResponseEntity(employee, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("deleteEmp/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable int id) {
		int flag = 0;

		flag = jdbcTemplate.update("DELETE from employee where id=?", id);

		if (flag > 0)
			return new ResponseEntity("Deleted from employee with id " + id, HttpStatus.OK);
		else
			return new ResponseEntity("not found", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/getAllEmp")
	public List<Employee> getAll() {
		List<Employee> empList = jdbcTemplate.query("select * from employee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

				// TODO Auto-generated method stub
				Employee em = new Employee();
				em.setId(rs.getInt("id"));
				em.setName(rs.getString("name"));
				em.setSalary(rs.getInt("salary"));
				return em;
			}

		});
		return empList;
	}

	@PostMapping("/registerAllEmp")
	public int[][] registerAllEmp(@RequestBody List<Employee> empList) {
		String sql = "insert into employee values(?,?,?)";
		return jdbcTemplate.batchUpdate(sql, empList, empList.size(),

				new ParameterizedPreparedStatementSetter<Employee>() {
					@Override
					public void setValues(PreparedStatement ps, Employee employee) throws SQLException {
						ps.setInt(1, employee.getId());
						ps.setString(2, employee.getName());
						ps.setInt(3, employee.getSalary());
					}

				});
	}
//	class MyResultExtractor1 implements ResultSetExtractor<List<Employee>>{
//	
//	@Override
//	public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
//		// TODO Auto-generated method stub
//		List<Employee> e2=Collections.emptyList();
//		while(rs.next()) {
//		
//		Employee e=new Employee();
//		e.setId(rs.getInt("id"));
//		e.setName(rs.getString("name"));
//		e.setSalary(rs.getInt("salary"));
//		e2.add(e);
//		}
//		return e2;
//	}
	
//	@GetMapping("/getAllEmp")
//	public List<Employee> getAllEmp()
//	{
//		List<Employee> e1=jdbcTemplate.query("select * from employee", new MyResultExtractor1());
//		return e1;
//	}

}
