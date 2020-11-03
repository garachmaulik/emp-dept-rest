package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("FROM Employee where dept_id= :id")
	public List<Employee> getById(@Param("id") int deptId);

}
