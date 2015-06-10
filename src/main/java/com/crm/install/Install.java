package com.crm.install;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.DigestUtils;

import com.crm.domain.Privilege;
import com.crm.domain.User;

/**
 * 用于初始化数据, 只执行一次
 * 
 */
public class Install {

	private SessionFactory sessionFactory;

	public void install() {
		Session session = sessionFactory.getCurrentSession();

		// 插入一个超级管理员用户
		User user = new User();
		user.setUsername("admin");
		user.setPassword(DigestUtils.md5DigestAsHex("admin".getBytes()));
		session.save(user);

		Privilege menuRoot = new Privilege("系统管理", null, null); // 该权限为最大权限者

		Privilege menuChildren = new Privilege("孩子管理", "childrenAction_list", menuRoot);
		Privilege menuGoodsOrder = new Privilege("订单管理", "goodsOrderAction_list", menuRoot);
		Privilege menuDepartment = new Privilege("部门管理", "departmentAction_list", menuRoot);
		Privilege menuUser = new Privilege("用户管理", "userAction_list", menuRoot);
		Privilege menuGoodsSetMeal = new Privilege("套餐管理", "goodsSetMeal_list", menuRoot);
		Privilege menuRole = new Privilege("角色管理", "roleAction_list", menuRoot);
		Privilege menuGoods = new Privilege("商品管理", "goods_list", menuRoot);
		Privilege menuSupplier = new Privilege("供应商管理", "supplier_list", menuRoot);
		Privilege menuGoodsCategories = new Privilege("商品分类管理", "goodsCategories_list", menuRoot);
		Privilege menuClient = new Privilege("客户管理", "client_list", menuRoot);
		Privilege menuEmployee = new Privilege("员工管理", "employee_list", menuRoot);

		// root
		session.save(menuRoot); // 一级权限(顶级权限), 根权限. 下面的都是它的子权限

		// root 下面的子权限.  就像一个树
		// 二级权限
		session.save(menuChildren);
		session.save(menuGoodsOrder);
		session.save(menuDepartment);
		session.save(menuUser);
		session.save(menuGoodsSetMeal);
		session.save(menuRole);
		session.save(menuGoods);
		session.save(menuSupplier);
		session.save(menuGoodsCategories);
		session.save(menuClient);
		session.save(menuEmployee);
		
		
		// 三级权限 开始
		session.save(new Privilege("孩子管理","children_list",menuChildren));
		session.save(new Privilege("孩子删除","children_delete",menuChildren));
		session.save(new Privilege("孩子添加","children_add",menuChildren));
		session.save(new Privilege("孩子修改","children_edit",menuChildren));
		
		session.save(new Privilege("订单管理","goodsOrder_list",menuGoodsOrder));
		session.save(new Privilege("订单删除","goodsOrder_delete",menuGoodsOrder));
		session.save(new Privilege("订单添加","goodsOrder_add",menuGoodsOrder));
		session.save(new Privilege("订单修改","goodsOrder_edit",menuGoodsOrder));
		
		session.save(new Privilege("部门管理","department_list",menuDepartment));
		session.save(new Privilege("部门删除","department_delete",menuDepartment));
		session.save(new Privilege("部门添加","department_add",menuDepartment));
		session.save(new Privilege("部门修改","department_edit",menuDepartment));
		
		session.save(new Privilege("用户管理","user_list",menuUser));
		session.save(new Privilege("用户删除","user_delete",menuUser));
		session.save(new Privilege("用户添加","user_add",menuUser));
		session.save(new Privilege("用户修改","user_edit",menuUser));
		
		session.save(new Privilege("套餐管理","goodsSetMeal_list",menuGoodsSetMeal));
		session.save(new Privilege("套餐删除","goodsSetMeal_delete",menuGoodsSetMeal));
		session.save(new Privilege("套餐添加","goodsSetMeal_add",menuGoodsSetMeal));
		session.save(new Privilege("套餐修改","goodsSetMeal_edit",menuGoodsSetMeal));
		
		session.save(new Privilege("角色管理","role_list",menuRole));
		session.save(new Privilege("角色删除","role_delete",menuRole));
		session.save(new Privilege("角色添加","role_add",menuRole));
		session.save(new Privilege("角色修改","role_edit",menuRole));
		
		session.save(new Privilege("商品管理","goods_list",menuGoods));
		session.save(new Privilege("商品删除","goods_delete",menuGoods));
		session.save(new Privilege("商品添加","goods_add",menuGoods));
		session.save(new Privilege("商品修改","goods_edit",menuGoods));
		
		session.save(new Privilege("供应商管理","supplier_list",menuSupplier));
		session.save(new Privilege("供应商删除","supplier_delete",menuSupplier));
		session.save(new Privilege("供应商添加","supplier_add",menuSupplier));
		session.save(new Privilege("供应商修改","supplier_edit",menuSupplier));
		
		session.save(new Privilege("商品分类管理","goodsCategories_list",menuGoodsCategories));
		session.save(new Privilege("商品分类删除","goodsCategories_delete",menuGoodsCategories));
		session.save(new Privilege("商品分类添加","goodsCategories_add",menuGoodsCategories));
		session.save(new Privilege("商品分类修改","goodsCategories_edit",menuGoodsCategories));
		
		session.save(new Privilege("客户管理","client_list",menuClient));
		session.save(new Privilege("客户删除","client_delete",menuClient));
		session.save(new Privilege("客户添加","client_add",menuClient));
		session.save(new Privilege("客户修改","client_edit",menuClient));
		
		session.save(new Privilege("员工管理","employee_list",menuEmployee));
		session.save(new Privilege("员工删除","employee_delete",menuEmployee));
		session.save(new Privilege("员工添加","employee_add",menuEmployee));
		session.save(new Privilege("员工修改","employee_edit",menuEmployee));
		
		// 三级权限 结束
		
		

	}

	public static void main(String[] args) {
		 ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext*.xml");
		 Install install = (Install) act.getBean("install");
		 install.install();
		 System.out.println("安装完毕");
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}
