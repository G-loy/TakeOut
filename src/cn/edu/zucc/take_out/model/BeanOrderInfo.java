package cn.edu.zucc.take_out.model;

public class BeanOrderInfo {
     private int orderId;
     private int productId;
     private int number;
     private double money;
     private double perDiscount;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getPerDiscount() {
		return perDiscount;
	}
	public void setPerDiscount(double perDiscount) {
		this.perDiscount = perDiscount;
	}
     
     
     
}
