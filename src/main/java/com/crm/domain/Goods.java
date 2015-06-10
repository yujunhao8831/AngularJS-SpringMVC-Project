package com.crm.domain;

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
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 商品
 * 商品和类别的关系,* --- *
 * 商品和套餐的关系,* --- *
 */
@Entity
@Table(name="GOODS_")
public class Goods extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/** 商品编号 **/
	private String goodsId; 
	/** 商品名称 **/
	private String name; 
	/** 商品进价 **/
	private double putPrice; 
	/** 商品卖价 **/
	private double outPrice; 
	/** 商品描述 **/
	private String description; 
	
	/** 该商品属于多个类别. **/
	private Set<GoodsClassification> goodsClassificationSet = new HashSet<GoodsClassification>();  
	
	/** 该商品下的套餐,属于多个套餐 **/
	private Set<GoodsSetMeal> goodsSetMealSet = new HashSet<GoodsSetMeal>(); 
	
	
	@Column(name="GOODS_ID")
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	@Column(name="NAME_")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="PUTPRICE_")
	public double getPutPrice() {
		return putPrice;
	}
	public void setPutPrice(double putPrice) {
		this.putPrice = putPrice;
	}
	@Column(name="OUTPRICE_")
	public double getOutPrice() {
		return outPrice;
	}
	public void setOutPrice(double outPrice) {
		this.outPrice = outPrice;
	}
	@Column(name="DESCRIPTION_")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
		
	@JsonBackReference
	@ManyToMany(targetEntity=GoodsClassification.class,fetch=FetchType.LAZY)
	@JoinTable(name="GOODS_GOODSCLASSIFICATION_", joinColumns={ @JoinColumn(name="GOODS_ID_")},inverseJoinColumns={ @JoinColumn(name = "GOODSCLASSIFICATION_ID_") })
	public Set<GoodsClassification> getGoodsClassificationSet() {
		return goodsClassificationSet;
	}
	public void setGoodsClassificationSet(Set<GoodsClassification> goodsClassificationSet) {
		this.goodsClassificationSet = goodsClassificationSet;
	}
	
	
	@ManyToMany(targetEntity=GoodsSetMeal.class,fetch=FetchType.LAZY)
	@JoinTable(name="GOODS_GOODSSETMEAL_", joinColumns={ @JoinColumn(name="GOODS_ID_")},inverseJoinColumns={ @JoinColumn(name = "GOODSSETMEALSET_ID_") })
	public Set<GoodsSetMeal> getGoodsSetMealSet() {
		return goodsSetMealSet;
	}
	public void setGoodsSetMealSet(Set<GoodsSetMeal> goodsSetMealSet) {
		this.goodsSetMealSet = goodsSetMealSet;
	}
	
	
	
	
	 
	
	
}
