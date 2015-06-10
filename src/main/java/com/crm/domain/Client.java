package com.crm.domain;

import java.beans.Transient;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.crm.core.domain.BaseEntity;
/*
id  
name
sex
phoneNumber
birthday
age
address
description
marriageTime  
childrenSet 
employee
goodsOrderSet 
 
 
 */
/**
 * 客户
 * 客户和订单的关系,1 --- *
 * 客户和孩子的关系,1 --- *
 * 客户和员工的关系,* --- *
 */
@Entity
@Table(name="CLIENT_")
public class Client extends BaseEntity{
	private static final long serialVersionUID = 1L;
	/** 客户名 **/
	private String name; 
	/** 性别 **/
	private boolean sex; 
	/** 电话 **/
	private String phoneNumber; 
	/** 生日 **/
	private Date birthday; 
	/** 年龄,不进行映射 **/
	private int age; 
	/** 地址 **/
	private String address; 
	/** 描述 **/
	private String description; 
	/** 结婚时间 **/
	private Date marriageTime; 
	/** 孩子 **/
	private Set<Children> childrenSet = new HashSet<Children>(); 
	/** 被哪些员工受理过 **/
	private Set<Employee> employeeSet = new HashSet<Employee>(); 
	/** 多个订单 **/
	private Set<GoodsOrder> goodsOrderSet = new HashSet<GoodsOrder>(); 
	
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
	
	@Column(name="BIRTHDAY_")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Transient
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	
	@Column(name="MARRIAGETIME_")
	public Date getMarriageTime() {
		return marriageTime;
	}
	public void setMarriageTime(Date marriageTime) {
		this.marriageTime = marriageTime;
	}
	
	 
	@OneToMany(mappedBy="client")
	public Set<Children> getChildrenSet() {
		return childrenSet;
	}
	public void setChildrenSet(Set<Children> childrenSet) {
		this.childrenSet = childrenSet;
	}
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="clientSet")
	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}
	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}
	
	@OneToMany(mappedBy="client")
	public Set<GoodsOrder> getGoodsOrderSet() {
		return goodsOrderSet;
	}
	public void setGoodsOrderSet(Set<GoodsOrder> goodsOrderSet) {
		this.goodsOrderSet = goodsOrderSet;
	}
	
	
	
	
}


