package com.crm.domain;

import java.beans.Transient;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.crm.core.domain.BaseEntity;

/**
 * 员工
 * 员工和部门的关系, * --- 1
 * 员工和上级的关系, * --- 1
 * 上级和员工的关系, 1 --- * 
 * 员工和客户的关系, * --- *
 */
@Entity
@Table(name="EMPLOYEE_")
public class Employee extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	/** 姓名 **/
	private String name; 
	/** 性别 **/
	private boolean sex; 
	/** 电话号码  **/
	private String phoneNumber; 
	/** 地址 **/
	private String address; 
	/** 描述 **/
	private String description; 
	/** 身份证  **/
	private String idCard; 
	/** 年龄 = 当前时间 - 生日,在数据库中不进行映射 **/
	private int age; 
	/** 生日  **/
	private Date birthday; 
	/** 薪水 = 薪水 + 薪水 * 提成,数据中不进行映射 **/
	private double salary; 
	/** 上级 **/
	private Employee parent; 
	/** 下级 **/
	private Set<Employee> children = new HashSet<Employee>();
	/** 所属部门 **/
	private Department department; 
	/** 员工和客户的关系 **/
	private Set<Client> clientSet = new HashSet<Client>(); 
	
	
	
	@Column(name="NAME_")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="SEX_")
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	@Column(name="PHONENUMBER_")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(name="ADDRESS_")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="DESCRIPTION_")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="IDCARD_")
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@Transient
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Column(name="BIRTHDAY_")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Transient
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID_")
	public Employee getParent() {
		return parent;
	}
	public void setParent(Employee parent) {
		this.parent = parent;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	public Set<Employee> getChildren() {
		return children;
	}
	public void setChildren(Set<Employee> children) {
		this.children = children;
	}
	
	/**
	 * @ManyToOne  : 指定了多对一的关系,fetch=FetchType.LAZY属性表示在多的那一方通过延迟加载的方式加载对象(默认不是延迟加载)
	 * @JoinColumn : 的name属性指定了外键的名称　
	 */
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EMPLOYEE_ID")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="EMPLOYEE_CLIENT_", joinColumns={ @JoinColumn(name="EMPLOYEE_ID_")},inverseJoinColumns={ @JoinColumn(name = "CLIENT_ID_") })
	public Set<Client> getClientSet() {
		return clientSet;
	}
	public void setClientSet(Set<Client> clientSet) {
		this.clientSet = clientSet;
	}
}