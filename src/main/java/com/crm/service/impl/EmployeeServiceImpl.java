package com.crm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.core.base.BaseServiceImpl;
import com.crm.dao.EmployeeDao;
import com.crm.domain.Employee;
import com.crm.service.EmployeeService;
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, EmployeeDao> implements EmployeeService{

	@Override
	public List<Employee> findNotParentEmployee() {
		return dao.findNotParentEmployee();
	}
	
}
