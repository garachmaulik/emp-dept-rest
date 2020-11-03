package com.cg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Employee;
import com.cg.exceptions.NotFoundException;
import com.cg.service.IEmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService iEmployeeService;
	
	// URL: http://localhost:8080/addEmployee
	@PostMapping(value = "/addEmployee", consumes = "application/json")
	public String addEmp(@RequestBody Employee emp) {
		return iEmployeeService.add(emp);
	}
	
	// URL: http://localhost:8080/deleteEmployee
	@DeleteMapping(value = "/deleteEmployee")
	public String deleteEmp(@RequestParam("id") int empId) throws NotFoundException{
		return iEmployeeService.delete(empId);
	}
	
	// URL: http://localhost:8080/empList
	@GetMapping(value = "/empList", produces = "application/json")
	public List<Employee> emplist() throws NotFoundException{
		return iEmployeeService.list();
	}
	
	// URL: http://localhost:8080/empListById
	@GetMapping(value = "/empById")
	public Employee getById(@RequestParam("id") int empId) throws NotFoundException{
		return iEmployeeService.getById(empId);
	}
	
	// URL: http://localhost:8080/empByDept
	@GetMapping(value = "/empByDept")
	public List<Employee> getByDept(@RequestParam("id") int deptId) throws NotFoundException{
		return iEmployeeService.findByDept(deptId);
	}
	
}
