package com.crm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.core.base.BaseServiceImpl;
import com.crm.dao.PrivilegeDao;
import com.crm.domain.Privilege;
import com.crm.service.PrivilegeService;
@Service
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege, PrivilegeDao> implements PrivilegeService{

	@Override
	public List<Privilege> findRootPrivilegeList() {
		return dao.findRootPrivilegeList();
	}

}
