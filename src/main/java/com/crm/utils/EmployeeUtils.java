package com.crm.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crm.domain.Employee;


/**
 * 员工工具类 
 */
public class EmployeeUtils {
	
	/**
	 * 参数1: 所有没有上级员工的员工集合
	 * 参数2: 当前员工
	 * 过滤员工
	 * 1. 从员工集合中,分解每一个员工,在从每一个员工找下级. 寻找与当前员工相同的员工移除
	 * 2. 找到当前员工的顶级上级, employee.getParent().getParent().getParent()...; 找到后移除
	 * 3. 过滤掉自己
	 * -----------
	 * 目的 : 
	 * 		在页面中,如果为某员工,要添加下级
	 * 		1. 不能添加自己 ->> 过滤掉自己
	 * 		2. 自己以及是比人的下级了,那么就不能添加,上司的上司...顶级上司为下级员工,  这样会成了一个循环链表
	 * 		3. 自己的下级员工,不能在进行添加, 过滤掉这些.
	 * @return
	 */
	public static List<Employee> filterEmployee(List<Employee> notParentEmployeeList,Employee employee){

		Iterator<Employee> iterator = notParentEmployeeList.iterator(); // notParentEmployeeList : 所有没有上级的元素的集合
		List<Employee> childrenList = new ArrayList<Employee>(); // 保存有下级员工的所有下级的集合
		
		// 1. 从员工集合中,分解每一个员工,再从每一个员工找下级. start
		while (iterator.hasNext()) {
			Employee nextEmployee = (Employee) iterator.next(); // 没有上级的某元素
			lookChildren(childrenList,nextEmployee); // 传递的是指针,通过指针可以直接改变值.
		}
		notParentEmployeeList.removeAll(childrenList); // 移除.
		// 1. end
		
		// 2. 找到当前员工的顶级上级, employee.getParent().getParent().getParent()...; 找到后移除 start
		Employee boss = lookBoss(employee);
		notParentEmployeeList.remove(boss); // 移除
		// 2. end 
		
		// 3. 过滤掉自己 
		notParentEmployeeList.remove(employee);
		return notParentEmployeeList;
	}

	/**
	 * @param childrenList 保存所有下级
	 * @param employee 寻找该参数的所有下级
	 * @return
	 */
	private static void lookChildren(List<Employee> childrenList,Employee employee){
		for (Employee children : employee.getChildren()) {
			childrenList.add(children);
			lookChildren(childrenList,children);
		}
	}
	
	/**
	 * 找到顶级上司
	 */
	private static Employee lookBoss(Employee employee){
		Employee parent = employee;
		while (parent.getParent() != null) {
			parent = parent.getParent();
		}
		return parent;
	}
	
}
