package com.cg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Department;
import com.cg.exceptions.NotFoundException;
import com.cg.service.IDepartmentService;

@RestController
public class DepartmentRestController {

	@Autowired
	private IDepartmentService iDepartmentService;
	
	// URL: http://localhost:8080/addDepartment
	@PostMapping(value = "/addDepartment", consumes = "application/json")
	public String addDept(@RequestBody Department dept) {
		return iDepartmentService.add(dept);
	}

	// URL: http://localhost:8080/deleteDepartment
	@DeleteMapping(value = "/deleteDepartment")
	public String deleteDept(@RequestParam("id") int deptId) throws NotFoundException{
		return iDepartmentService.delete(deptId);
	}
	
	// URL: http://localhost:8080/deptList
	@GetMapping(value = "/deptList", produces = "application/json")
	public List<Department> deptlist() throws NotFoundException{
		return iDepartmentService.list();
	}

}
