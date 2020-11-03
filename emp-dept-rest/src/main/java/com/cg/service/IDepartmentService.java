package com.cg.service;

import java.util.List;

import com.cg.entity.Department;
import com.cg.exceptions.NotFoundException;

public interface IDepartmentService {

	public String add(Department department);

	public String delete(int deptId) throws NotFoundException;

	public List<Department> list() throws NotFoundException;

}
