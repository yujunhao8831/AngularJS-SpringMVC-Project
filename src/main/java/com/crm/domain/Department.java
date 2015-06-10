package com.crm.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.crm.core.domain.BaseEntity;

/**
 * 部门 
 * 部门和员工的关系, 1 --- *
 */
@Entity
@Table(name="DEPARTMENT_")
public class Department extends BaseEntity{
	private static final long serialVersionUID = 1L;
	/** 部门名称 **/
	private String name; 
	/** 部门下面的员工 **/
	private Set<Employee> employeeSet = new HashSet<Employee>(); 
	
	@Column(name="NAME_")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy="department")
	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}
	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}
	
	
	
	
	
	
	
}
