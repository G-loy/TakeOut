package cn.edu.zucc.take_out.model;

import java.util.Date;

public class BeanCouInfo {
     private int coupId;
     private double coupMoney;
     private int collRequest;
     private Date startTime;
     private Date finishTime;
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
