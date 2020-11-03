package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Department;
import com.cg.exceptions.NotFoundException;
import com.cg.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService{

	@Autowired
	private IDepartmentRepository iDepartmentRepository;
	
	@Override
	public String add(Department department){
		iDepartmentRepository.saveAndFlush(department);
		return "Department Successfully Added";
	}

	@Override
	public String delete(int deptId) throws NotFoundException{
		if(!iDepartmentRepository.existsById(deptId)) {
			throw new NotFoundException("Department does not exist with Id: " + deptId);
		}
		iDepartmentRepository.deleteById(deptId);
		return "Department Successfully Deleted";
	}

	@Override
	public List<Department> list() throws NotFoundException{
		List<Department> deptList = null;
		deptList =  iDepartmentRepository.findAll();
		if(deptList == null || deptList.isEmpty()) {
			throw new NotFoundException("Department List is Empty");
		}
		return deptList;
	}

}
