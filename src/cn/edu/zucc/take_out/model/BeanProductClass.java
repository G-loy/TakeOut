package cn.edu.zucc.take_out.model;

public class BeanProductClass {
	
	public static final String[] PRODUCT_CLASS_TITLE = {"类别ID","类别名","商品数量"};
	
	
	 public String getCell(int col) {
		 if(col==0) return String.valueOf(getClassId());
		 else if(col==1) return String.valueOf(getClassName());
		 else if(col==2) return String.valueOf(getProductNumber());
		 else return"";
	 }
       private int classId;
       private String className;
       private Integer productNumber;
       
       
       
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Integer getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}
            
       
}
