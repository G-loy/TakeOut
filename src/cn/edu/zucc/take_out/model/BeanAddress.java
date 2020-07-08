package cn.edu.zucc.take_out.model;

public class BeanAddress {
	
	public static final String[] ADDRESS_TITLE = {"地址ID","用户ID","省","市","区","具体地址","联系人","联系人电话"};
	
	
	
	 public String getCell(int col) {
		 if(col==0) return String.valueOf(getAddressId());
		 else if(col==1) return String.valueOf(getUserId());
		 else if(col==2) return String.valueOf(getProvince());
		 else if(col==3) return String.valueOf(getCity());
		 else if(col==4) return String.valueOf(getDistance());
		 else if(col==5) return String.valueOf(getAddressId());
		 else if(col==6) return String.valueOf(getLinkman());
		 else if(col==7) return String.valueOf(getPhoneNumber());
		 else return"";
	 }
	 
	
	
     private int addressId;
     private int userId;
     private String province;
     private String city;
     private String distance;
     private String address;
     private String linkman;
     private String phoneNumber;
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
     
}
