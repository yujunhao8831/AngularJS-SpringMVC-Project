package com.crm.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.core.base.BaseDaoImpl;
import com.crm.dao.PrivilegeDao;
import com.crm.domain.Privilege;
@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Privilege> findRootPrivilegeList() {
		return getSession().createQuery(//
				"FROM Privilege p WHERE p.parent IS NULL")// 这里 p.parent 写的是属性名,因为是HQL
				.list();
	}

}
