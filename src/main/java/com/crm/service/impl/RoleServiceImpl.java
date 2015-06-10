package com.crm.service.impl;


import org.springframework.stereotype.Service;

import com.crm.core.base.BaseServiceImpl;
import com.crm.dao.RoleDao;
import com.crm.domain.Role;
import com.crm.service.RoleService;
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleDao> implements RoleService{

}
