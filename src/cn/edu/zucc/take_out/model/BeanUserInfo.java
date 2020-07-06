package cn.edu.zucc.take_out.model;

import java.util.Date;

/**
    @Title:BeanUserInfo.java
    @author created by Pengkun Gu
    @version 1.0
    @date 2020年7月4日上午8:38:26
*/
public class BeanUserInfo {
	
	public static BeanUserInfo currentLoginUser = null;
	public static final String[] USER_TITLE= {"用户ID","用户姓名","用户性别","用户密码","用户电话","用户邮箱","城市","注册时间","是否是会员","会员到期日期"};
	
	 public String getCell(int col) {
		 if(col==0) return String.valueOf(getUserId());
		 else if(col==1) return String.valueOf(getUserName());
		 else if(col==2) return String.valueOf(getUserGender());
		 else if(col==3) return String.valueOf(getUserPwd());
		 else if(col==4) return String.valueOf(getUserPhone());
		 else if(col==5) return String.valueOf(getUserEmail());
		 else if(col==6) return String.valueOf(getUserCity());
		 else if(col==7) return String.valueOf(getUserRegistTime());
		 else if(col==8) return String.valueOf(getIsMember());
		 else if(col==9) return String.valueOf(getMemberDDL());
		 else return"";
	 }
	
	
	
    private int userId;
    private String userName;
    private String userGender;
    private String userPwd;
    private String userPhone;
    private String userEmail;
    private String userCity;
    private Date userRegistTime;
    private Boolean isMember;
    private Date memberDDL;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public Date getUserRegistTime() {
		return userRegistTime;
	}
	public void setUserRegistTime(java.sql.Date date) {
		this.userRegistTime = new Date(date.getTime());
	}
	public Boolean getIsMember() {
		return isMember;
	}
	public void setIsMember(Boolean isMember) {
		this.isMember = isMember;
	}
	public Date getMemberDDL() {
		return memberDDL;
	}
	public void setMemberDDL(Date memberDDL) {
		this.memberDDL = memberDDL;
	}
    
    
}
