package cn.edu.zucc.take_out.model;

import java.util.Date;

public class BeanCouInfo {
	
	public static final String[] CouTableTitle= {"优惠券ID","优惠金额","集券要求","开始时间","结束时间","商家ID"};
	
	 public String getCell(int col) {
		 if(col==0) return String.valueOf(getCoupId());
		 else if(col==1) return String.valueOf(getCoupMoney());
		 else if(col==2) return String.valueOf(getCollRequest());
		 else if(col==3) return String.valueOf(getStartTime());
		 else if(col==4) return String.valueOf(getFinishTime());
		 else if(col==5) return String.valueOf(getShopId());	
		 else return"";
	 }
	
     private int coupId;
     private double coupMoney;
     private int collRequest;
     private Date startTime;
     private Date finishTime;
     private int shopId;
    
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getCoupId() {
		return coupId;
	}
	public void setCoupId(int coupId) {
		this.coupId = coupId;
	}
	public double getCoupMoney() {
		return coupMoney;
	}
	public void setCoupMoney(double coupMoney) {
		this.coupMoney = coupMoney;
	}
	public int getCollRequest() {
		return collRequest;
	}
	public void setCollRequest(int collRequest) {
		this.collRequest = collRequest;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
     
}
