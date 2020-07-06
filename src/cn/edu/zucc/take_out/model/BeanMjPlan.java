package cn.edu.zucc.take_out.model;

public class BeanMjPlan {
    private int mjID;
    private double mjMoney;
    private double dicountMoney;
    private boolean canADD;
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
