package com.crm.service;

import java.util.List;

import com.crm.core.base.BaseService;
import com.crm.dao.PrivilegeDao;
import com.crm.domain.Privilege;

public interface PrivilegeService extends BaseService<Privilege, PrivilegeDao>{
	public List<Privilege> findRootPrivilegeList();
}
