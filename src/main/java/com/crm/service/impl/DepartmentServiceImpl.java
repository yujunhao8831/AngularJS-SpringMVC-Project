package com.crm.service.impl;

import org.springframework.stereotype.Service;

import com.crm.core.base.BaseServiceImpl;
import com.crm.dao.DepartmentDao;
import com.crm.domain.Department;
import com.crm.service.DepartmentService;
@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department, DepartmentDao> implements DepartmentService{

}
