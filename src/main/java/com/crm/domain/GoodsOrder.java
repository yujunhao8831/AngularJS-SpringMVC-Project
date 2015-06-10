package com.crm.domain;

import java.beans.Transient;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.crm.core.domain.BaseEntity;


/**
 * 订单
 * 订单和套餐的关系 * --- *
 * 订单和客户的关系 * --- 1
 */
@Entity
@Table(name="GOODSORDER_")
public class GoodsOrder extends BaseEntity{

	private static final long serialVersionUID = 1L;
	/** 编号 **/
	private String goodsOrderId; 
	/** 预约收款 **/
	private double reservationReceipts;
	/** 预约时间 **/
	private Date anAppointmentTime ;
	/** 预约打折 **/
	private int bookingDiscount; 
	/** 拍照时间 **/
	private Date timeToTakePhotographs; 
	/** 选片时间 **/
	private Date chipSelectTime;  

	/** 已收款 **/
	private double hasReceivables;	
	/** 应收款 **/
	private double receivables; 
	/** 欠款 **/
	private double arrears; 
	/** 总价 = 总价 - (总计 * 预约打折),在数据库中不进行映射 */
	private double price; 
	/** 套餐 **/
	private Set<GoodsSetMeal> goodsSetMealSet = new HashSet<GoodsSetMeal>();  

	/** 客户 该订单属于哪个客户. **/
	private Client client; 
	
	
	
	@Column(name="GOODSORDERID_")
	public String getGoodsOrderId() {
		return goodsOrderId;
	}
	public void setGoodsOrderId(String goodsOrderId) {
		this.goodsOrderId = goodsOrderId;
	}
	@Column(name="RESERVATIONRECEIPTS_")
	public double getReservationReceipts() {
		return reservationReceipts;
	}
	public void setReservationReceipts(double reservationReceipts) {
		this.reservationReceipts = reservationReceipts;
	}
	
	@Column(name="ANAPPOINTMENTTIME_")
	public Date getAnAppointmentTime() {
		return anAppointmentTime;
	}
	public void setAnAppointmentTime(Date anAppointmentTime) {
		this.anAppointmentTime = anAppointmentTime;
	}
	@Column(name="BOOKINGDISCOUNT_")
	public int getBookingDiscount() {
		return bookingDiscount;
	}
	public void setBookingDiscount(int bookingDiscount) {
		this.bookingDiscount = bookingDiscount;
	}
	@Column(name="TIMETOTAKEPHOTOGRAPHS_")
	public Date getTimeToTakePhotographs() {
		return timeToTakePhotographs;
	}
	public void setTimeToTakePhotographs(Date timeToTakePhotographs) {
		this.timeToTakePhotographs = timeToTakePhotographs;
	}
	@Column(name="CHIPSELECTTIME_")
	public Date getChipSelectTime() {
		return chipSelectTime;
	}
	public void setChipSelectTime(Date chipSelectTime) {
		this.chipSelectTime = chipSelectTime;
	}
	@Column(name="HASRECEIVABLES_")
	public double getHasReceivables() {
		return hasReceivables;
	}
	public void setHasReceivables(double hasReceivables) {
		this.hasReceivables = hasReceivables;
	}
	
	@Column(name="RECEIVABLES_")
	public double getReceivables() {
		return receivables;
	}
	public void setReceivables(double receivables) {
		this.receivables = receivables;
	}
	@Column(name="ARREARS_")
	public double getArrears() {
		return arrears;
	}
	public void setArrears(double arrears) {
		this.arrears = arrears;
	}

	/** 如果不想跟字段关联需要使用Transient注解表示是一个瞬时属性 */
	@Transient
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="goodsOrderSet") 
	public Set<GoodsSetMeal> getGoodsSetMealSet() {
		return goodsSetMealSet;
	}
	public void setGoodsSetMealSet(Set<GoodsSetMeal> goodsSetMealSet) {
		this.goodsSetMealSet = goodsSetMealSet;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GOODSORDER_ID_")
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
