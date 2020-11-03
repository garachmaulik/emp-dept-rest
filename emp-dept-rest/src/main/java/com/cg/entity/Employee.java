package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@SequenceGenerator(name = "seqgen", sequenceName = "empSeq", initialValue = 1)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Employee {

	@Id
	@GeneratedValue(generator = "seqgen")
	private int empId;

	@Column(length = 30)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")
	private Department dept;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

}
