package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Employee;
import com.cg.exceptions.NotFoundException;
import com.cg.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepository iEmployeeRepository;

	@Override
	public String add(Employee employee) {
		iEmployeeRepository.saveAndFlush(employee);
		return "Employee Added Successfully";
	}

	@Override
	public String delete(int empId) throws NotFoundException {
		if(!iEmployeeRepository.existsById(empId)) {
			throw new NotFoundException("Employee does not exist with Id: " + empId);
		}
		iEmployeeRepository.deleteById(empId);
		return "Employee Deleted Successfully";
	}

	@Override
	public List<Employee> list() throws NotFoundException {
		List<Employee> list = null;
		list = iEmployeeRepository.findAll();
		if(list == null || list.isEmpty()) {
			throw new NotFoundException("Employee List is Empty");
		}
		return list;
	}

	@Override
	public Employee getById(int empId) throws NotFoundException {
		Employee emp =  iEmployeeRepository.getOne(empId);
		if(emp == null) {
			throw new NotFoundException("Employee does not exist with Id: " + empId);
		}
		return emp;
	}

	@Override
	public List<Employee> findByDept(int deptId) throws NotFoundException {
		List<Employee> empListByDept = null;
		empListByDept =  iEmployeeRepository.getById(deptId);
		if(empListByDept == null || empListByDept.isEmpty()) {
			throw new NotFoundException("Employees do not exist with Department Id: " + deptId);
		}
		return empListByDept;
	}

}
