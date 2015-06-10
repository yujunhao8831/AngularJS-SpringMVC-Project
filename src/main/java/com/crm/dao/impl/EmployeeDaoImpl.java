package com.crm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.core.base.BaseDaoImpl;
import com.crm.dao.EmployeeDao;
import com.crm.domain.Employee;

@SuppressWarnings("unchecked")
@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao {
	/**
	 * 查询没有上级的员工 parentId is null
	 */
	@Override
	public List<Employee> findNotParentEmployee() {
		return getSession().createQuery(//
				"FROM Employee e WHERE e.parent IS NULL")// HQL
				// "FROM Employee e WHERE e.parentId IS NULL")// error SQL
				.list();
	}

}
