package cn.edu.zucc.take_out.model;

import java.util.Date;

/**
    @Title:BeanProductOrder.java
    @author created by Pengkun Gu
    @version 1.0
    @date 2020年7月4日上午8:20:22
*/
public class BeanProductOrder {
     private int orderId;
     private int ShopId;
     private int addressId;
     private int userId;
     private int mjId;
     private int riderId;
     private int coupId;
     private double orgMoney;
     private double finallyMoney;
     private Date drderTime;
     private Date serviceTime;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getShopId() {
		return ShopId;
	}
	public void setShopId(int shopId) {
		ShopId = shopId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMjId() {
		return mjId;
	}
	public void setMjId(int mjId) {
		this.mjId = mjId;
	}
	public int getRiderId() {
		return riderId;
	}
	public void setRiderId(int riderId) {
		this.riderId = riderId;
	}
	public int getCoupId() {
		return coupId;
	}
	public void setCoupId(int coupId) {
		this.coupId = coupId;
	}
	public double getOrgMoney() {
		return orgMoney;
	}
	public void setOrgMoney(double orgMoney) {
		this.orgMoney = orgMoney;
	}
	public double getFinallyMoney() {
		return finallyMoney;
	}
	public void setFinallyMoney(double finallyMoney) {
		this.finallyMoney = finallyMoney;
	}
	public Date getDrderTime() {
		return drderTime;
	}
	public void setDrderTime(Date drderTime) {
		this.drderTime = drderTime;
	}
	public Date getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}
     
     
     
}
