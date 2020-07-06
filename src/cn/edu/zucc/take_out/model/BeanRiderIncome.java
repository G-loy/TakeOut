package cn.edu.zucc.take_out.model;

import java.util.Date;

/**
    @Title:BeanRiderIncome.java
    @author created by Pengkun Gu
    @version 1.0
    @date 2020年7月4日上午8:24:59
*/
public class BeanRiderIncome {
	private int riderIncomeId;
	private int riderId;
	private int orderId;
	private Date time;
	private String userEval;
	
	
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
