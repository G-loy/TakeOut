package cn.edu.zucc.take_out.model;

public class BeanMjPlan {
	
	public static final String[] MjPlANTITLE = {"满减计划ID","商家ID","满减金额","优惠金额","能否与优惠券叠加"};
	
	
	 public String getCell(int col) {
		 if(col==0) return String.valueOf(getMjID());
		 else if(col==1) return String.valueOf(getShop_Id());
		 else if(col==2) return String.valueOf(getMjMoney());
		 else if(col==3) return String.valueOf(getDicountMoney());
		 else if(col==4) {
			 if (isCanADD()==true){
				 return "能";
			 }else {
				 return"不能";
			 }
		 }
		 else return"";
	 }
	
	
	
    private int mjID;
    private double mjMoney;
    private double dicountMoney;
    private boolean canADD;
    private int shop_Id;
    
	public int getShop_Id() {
		return shop_Id;
	}
	public void setShop_Id(int shop_Id) {
		this.shop_Id = shop_Id;
	}
	public int getMjID() {
		return mjID;
	}
	public void setMjID(int mjID) {
		this.mjID = mjID;
	}
	public double getMjMoney() {
		return mjMoney;
	}
	public void setMjMoney(double mjMoney) {
		this.mjMoney = mjMoney;
	}
	public double getDicountMoney() {
		return dicountMoney;
	}
	public void setDicountMoney(double dicountMoney) {
		this.dicountMoney = dicountMoney;
	}
	public boolean isCanADD() {
		return canADD;
	}
	public void setCanADD(boolean canADD) {
		this.canADD = canADD;
	}
    
}
