package com.crm.service;

import java.util.List;

import com.crm.core.base.BaseService;
import com.crm.dao.EmployeeDao;
import com.crm.domain.Employee;

public interface EmployeeService extends BaseService<Employee, EmployeeDao>{
	public List<Employee> findNotParentEmployee();
}
