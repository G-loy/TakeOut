package cn.edu.zucc.take_out.model;

import java.util.Date;

/**
    @Title:BeanProductOrder.java
    @author created by Pengkun Gu
    @version 1.0
    @date 2020年7月4日上午8:20:22
*/
public class BeanProductOrder {
	
	 public static  final String[] PRODUCTORDER_TITLE = {"订单号","商家ID","满减ID","骑手ID","优惠券ID","原始价钱","实付价钱","下单时间","要求送达时间","状态"};
	 
		public Object getCell(int col) {
			// TODO Auto-generated method stub
			 if(col==0) return String.valueOf(getOrderId());
			 else if(col==1) return String.valueOf(getShopId());
			 else if(col==2) return String.valueOf(getMjId());
			 else if(col==3) return String.valueOf(getRiderId());
			 else if(col==4) return String.valueOf(getCoupId());
			 else if(col==5) return String.valueOf(getOrgMoney());
			 else if(col==6) return String.valueOf(getFinallyMoney());
			 else if(col==7) return String.valueOf(getDrderTime());
			 else if(col==8) return String.valueOf(getServiceTime());
			 else if(col==9) return String.valueOf(getState());
			 else return"";
		}
	
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
     private String state;
     
     
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
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
