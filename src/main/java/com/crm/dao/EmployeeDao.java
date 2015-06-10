package com.crm.dao;

import java.util.List;

import com.crm.core.base.BaseDao;
import com.crm.domain.Employee;

public interface EmployeeDao extends BaseDao<Employee>{
	/**
	 * 查询没有上级的员工
	 * parentId is null
	 */
	public List<Employee> findNotParentEmployee();
	
	
}
