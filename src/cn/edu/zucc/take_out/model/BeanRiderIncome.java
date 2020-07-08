package cn.edu.zucc.take_out.model;

import java.util.Date;

/**
    @Title:BeanRiderIncome.java
    @author created by Pengkun Gu
    @version 1.0
    @date 2020年7月4日上午8:24:59
*/
public class BeanRiderIncome {
	
	public static final String[] BEAN_RIDER_INCOME =  {"账单ID","骑手ID","订单ID","入账时间","用户评价","单笔收入"};
	
	 public String getCell(int col) {
		 if(col==0) return String.valueOf(getRiderIncomeId());
		 else if(col==1) return String.valueOf(getRiderId());
		 else if(col==2) return String.valueOf(getOrderId());
		 else if(col==3) return String.valueOf(getTime());
		 else if(col==4) return String.valueOf(getUserEval());
		 else return"";
	 }
	
	
	private int riderIncomeId;
	private int riderId;
	private int orderId;
	private Date time;
	private String userEval;
	private double income;
	
	
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public int getRiderIncomeId() {
		return riderIncomeId;
	}
	public void setRiderIncomeId(int riderIncomeId) {
		this.riderIncomeId = riderIncomeId;
	}
	public int getRiderId() {
		return riderId;
	}
	public void setRiderId(int riderId) {
		this.riderId = riderId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getUserEval() {
		return userEval;
	}
	public void setUserEval(String userEval) {
		this.userEval = userEval;
	}
	
	
	

}
