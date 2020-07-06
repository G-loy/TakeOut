package cn.edu.zucc.take_out.model;
/**
    @Title:Bean.java
    @author created by Pengkun Gu
    @version 1.0
    @date 2020年7月4日上午8:31:32
*/
public class BeanShopInfo {
	
	public static final String[] SHOP_TITLE = {"商家ID名","商家名称","商家星等级","商家平均销售额","商家总销售额"};
	
	private int shopId;
	private String shopName;
	private int shopStar;
	private double conAvg;
	private double totalSale;
	
	 public String getCell(int col) {
		 if(col==0) return String.valueOf(getShopId());
		 else if(col==1) return String.valueOf(getShopName());
		 else if(col==2) return String.valueOf(getShopStar());
		 else if(col==3) return String.valueOf(getConAvg());
		 else if(col==4) return String.valueOf(getTotalSale());
		 else return"";
	 }
	
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public int getShopStar() {
		return shopStar;
	}
	public void setShopStar(int shopStar) {
		this.shopStar = shopStar;
	}
	public double getConAvg() {
		return conAvg;
	}
	public void setConAvg(double conAvg) {
		this.conAvg = conAvg;
	}
	public double getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(double totalSale) {
		this.totalSale = totalSale;
	}
	
	

}
