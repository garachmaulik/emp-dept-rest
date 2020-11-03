package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer>{

}
