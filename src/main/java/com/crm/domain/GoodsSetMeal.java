package com.crm.domain;

import java.beans.Transient;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.crm.core.domain.BaseEntity;

/**
 * 商品套餐
 * 商品套餐和商品的关系,* --- * 
 * 商品套餐和订单的关系,* --- *
 */
@Entity
@Table(name="GOODSSETMEAL_")
public class GoodsSetMeal extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 套餐名 **/
	private String name; 
	/** 赠送 **/
	private int givePhotoNumber;  
	/** 价格,不映射到数据库 **/
	private double price; 
	/** 套餐下的商品,套餐包括多个商品 **/
	private Set<Goods> goodsSet = new HashSet<Goods>(); 
	/** 套餐下的订单,套餐可以被多个订单使用. **/
	private Set<GoodsOrder> goodsOrderSet = new HashSet<GoodsOrder>(); 
	
	@Column(name="NAME_")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="GIVEPHOTONUMBER_")
	public int getGivePhotoNumber() {
		return givePhotoNumber;
	}
	public void setGivePhotoNumber(int givePhotoNumber) {
		this.givePhotoNumber = givePhotoNumber;
	}
	@Transient
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="goodsSetMealSet") 
	public Set<Goods> getGoodsSet() {
		return goodsSet;
	}
	public void setGoodsSet(Set<Goods> goodsSet) {
		this.goodsSet = goodsSet;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="USER_ROLE_", joinColumns={ @JoinColumn(name="GOODSSETMEAL_ID_")},inverseJoinColumns={ @JoinColumn(name = "GOODSORDER_ID_") })
	public Set<GoodsOrder> getGoodsOrderSet() {
		return goodsOrderSet;
	}
	public void setGoodsOrderSet(Set<GoodsOrder> goodsOrderSet) {
		this.goodsOrderSet = goodsOrderSet;
	}
	
	
	
	
	
}
