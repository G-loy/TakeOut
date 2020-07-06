package cn.edu.zucc.take_out.model;
/**
    @Title:BeanRiderInfo.java
    @author created by Pengkun Gu
    @version 1.0
    @date 2020年7月4日上午8:27:57
*/

import java.util.Date;

public class BeanRiderInfo {
	
	 public static final String[] Rider_TITLE = {"骑手ID","骑手姓名","骑手入职日期","骑手状态"};
	
	 public String getCell(int col) {
		 if(col==0) return String.valueOf(getRiderId());
		 else if(col==1) return String.valueOf(getRiderName());
		 else if(col==2) return String.valueOf(getBoardDate());
		 else if(col==3) return String.valueOf(getRiderSta());
		 else return"";
	 }
	
     private  int riderId;
     private  String riderName;
     private  Date boardDate;
     private  int riderSta;
     
     
	public int getRiderId() {
		return riderId;
	}
	public void setRiderId(int riderId) {
		this.riderId = riderId;
	}
	public String getRiderName() {
		return riderName;
	}
	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public int getRiderSta() {
		return riderSta;
	}
	public void setRiderSta(int riderSta) {
		this.riderSta = riderSta;
	}
     
     
}
