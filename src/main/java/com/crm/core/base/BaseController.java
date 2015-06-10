package com.crm.core.base;

import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.service.ChildrenService;
import com.crm.service.ClientService;
import com.crm.service.DepartmentService;
import com.crm.service.EmployeeService;
import com.crm.service.GoodsClassificationService;
import com.crm.service.GoodsOrderService;
import com.crm.service.GoodsService;
import com.crm.service.GoodsSetMealService;
import com.crm.service.PrivilegeService;
import com.crm.service.RoleService;
import com.crm.service.SupplierService;
import com.crm.service.UserService;

@SuppressWarnings("unchecked")
public abstract class BaseController<T>{
	protected Class<T> modelClass;
	
	@Autowired
	protected UserService userService;
	@Autowired
	protected SupplierService supplierService;
	@Autowired
	protected EmployeeService employeeService;
	@Autowired
	protected DepartmentService departmentService;
	@Autowired
	protected ClientService clientService;
	@Autowired
	protected ChildrenService childrenService;
	@Autowired
	protected GoodsOrderService goodsOrderService;
	@Autowired
	protected GoodsSetMealService goodsSetMealService;
	@Autowired
	protected GoodsService goodsService;
	@Autowired
	protected GoodsClassificationService goodsClassificationService;
	@Autowired
	protected PrivilegeService privilegeService;
	@Autowired
	protected RoleService roleService; 
	
	protected final String REDIRECT = "redirect:";
	
	public BaseController() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		modelClass = (Class<T>) type.getActualTypeArguments()[0];
		
		
	}

	
}
