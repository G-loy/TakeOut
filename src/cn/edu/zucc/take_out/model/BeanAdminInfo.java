package cn.edu.zucc.take_out.model;

public class BeanAdminInfo {
     public static final String[] adminTableTitle= {"序号","管理员账户名","账户密码"};
	 public static BeanAdminInfo currentLoginAdmin=null;
	
	 public String getCell(int col) {
		 if(col==0) return String.valueOf(getAdmId());
		 else if(col==1) return String.valueOf(getAdmName());
		 else if(col==2) return String.valueOf(getAdmPassword());
		 else return"";
	 }
	 
	 
     private Integer admId;
     private String admName;
     private String admPassword;
     
	public Integer getAdmId() {
		return admId;
	}
	public void setAdmId(Integer admId) {
		this.admId = admId;
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	public String getAdmPassword() {
		return admPassword;
	}
	public void setAdmPassword(String admPassword) {
		this.admPassword = admPassword;
	}
     
}
