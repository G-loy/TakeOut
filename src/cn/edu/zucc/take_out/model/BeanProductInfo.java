package cn.edu.zucc.take_out.model;
/**
    @Title:BeanProductInfo.java
    @author created by Pengkun Gu
    @version 1.0
    @date 2020年7月4日上午8:16:11
*/
public class BeanProductInfo {
     private int productId;
     private int classId;
     private String productName;
     private double productPrice;
     private double prefPrice;
     private int number;
     
     
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public double getPrefPrice() {
		return prefPrice;
	}
	public void setPrefPrice(double prefPrice) {
		this.prefPrice = prefPrice;
	}
     
     
     
}
