package cn.edu.zucc.take_out.model;

import java.sql.Blob;
import java.util.Date;
/**
@Title:BeanProductInfo.java
@author created by Pengkun Gu
@version 1.0
@date 2020年7月4日上午8:16:11
*/
public class BeanProductEvaluateInfo {
     private int userId;
     private int productId;
     private int shopId;
     private String details;
     private Date date;
     private int star;
     private Blob photo; //照片大文件
     
     
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
     
}
