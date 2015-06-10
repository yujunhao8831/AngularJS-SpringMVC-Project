package com.crm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.crm.core.domain.BaseEntity;

/**
 * 供应商
 *  
 */
@Entity
@Table(name="SUPPLIER_")
public class Supplier extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 名称 **/
	private String name; 
	/** 电话 **/
	private String phoneNumber; 
	/** 地址 **/
	private String address; 
	/** 网址 **/
	private String website; 
	/** 邮政编码 **/
	private String zipCode; 
	/** 传真 **/
	private String fax;
	@Column(name="NAME_")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Column(name="WEBSITE_")
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	@Column(name="ZIPCODE_")
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Column(name="FAX_")
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	
	
}
