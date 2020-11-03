package com.cg.service;

import java.util.List;

import com.cg.entity.Employee;
import com.cg.exceptions.NotFoundException;

public interface IEmployeeService {
	
	public String add(Employee employee);
	
	public String delete(int empId) throws NotFoundException;
	
	public List<Employee> list() throws NotFoundException;
	
	public Employee getById(int empId) throws NotFoundException;
	
	public List<Employee> findByDept(int deptId) throws NotFoundException;

}
