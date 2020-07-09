package cn.edu.zucc.take_out.model;

import java.util.Date;

/**
    @Title:BeanUserHasCouInfo.java
    @author created by Pengkun Gu
    @version 1.0
    @date 2020年7月4日上午8:35:05
*/
public class BeanUserHasCouInfo {
	
	public static final String[] BEANUSERHASCOUINFO_TITEL = {"优惠券ID","商家ID","优惠金额","数量","截止日期"};
	
	public String getCell(int col) {
		 if(col==0) return String.valueOf(getCouId());
		 else if(col==1) return String.valueOf(getDiscountMoney());
		 else if(col==2) return String.valueOf(getNumber());
		 else if(col==3) return String.valueOf(getDdl());
		 else return"";
	 }
	
      private int userId;
      private int couId;
      private int shopId;
      private double discountMoney;
      private int number;
      private Date ddl;
      
      
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCouId() {
		return couId;
	}
	public void setCouId(int couId) {
		this.couId = couId;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public double getDiscountMoney() {
		return discountMoney;
	}
	public void setDiscountMoney(double discountMoney) {
		this.discountMoney = discountMoney;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getDdl() {
		return ddl;
	}
	public void setDdl(Date ddl) {
		this.ddl = ddl;
	}
      
      
      
}
