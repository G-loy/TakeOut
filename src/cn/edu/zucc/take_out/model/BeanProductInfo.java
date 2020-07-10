package cn.edu.zucc.take_out.model;
/**
    @Title:BeanProductInfo.java
    @author created by Pengkun Gu
    @version 1.0
    @date 2020年7月4日上午8:16:11
*/
public class BeanProductInfo {
	 
	 public static final String[] PRODUCT_TITLE = {"商品ID","商品名","商品价格","优惠价格","库存"};
	
	 public String getCell(int col) {
		 if(col==0) return String.valueOf(getProductId());
		 else if(col==1) return String.valueOf(getProductName());
		 else if(col==2) return String.valueOf(getProductPrice());
		 else if(col==3) return String.valueOf(getPrefPrice());
		 else if(col==4) return String.valueOf(getNumber());
		 else return"";
	 }
	 
     private int productId;
     private int classId;
     private String productName;
     private double productPrice;
     private double prefPrice;
     private int number;
     private int shop_id;
     
     
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public static String[] getProductTitle() {
		return PRODUCT_TITLE;
	}
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
