package com.crm.dao;

import java.util.List;

import com.crm.core.base.BaseDao;
import com.crm.domain.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege>{
	public List<Privilege> findRootPrivilegeList();
}
