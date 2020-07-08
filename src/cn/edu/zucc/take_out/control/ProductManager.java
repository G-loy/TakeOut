package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.take_out.itf.IProductManager;
import cn.edu.zucc.take_out.model.BeanProductClass;
import cn.edu.zucc.take_out.model.BeanProductInfo;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.BusinessException;
import cn.edu.zucc.take_out.util.DruidUtil;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月6日
 */
public class ProductManager implements IProductManager {

	@SuppressWarnings("resource")
	@Override
	public BeanProductInfo add(String className, String productName, Double price, Double prefPrice, Integer number)
			throws BaseException {
		int classId = 0;
		// TODO Auto-generated method stub
		Connection con  = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			con=DruidUtil.getConnection();
			String sql = "SELECT count(*) from Product_info WHERE product_name = ?";
			pst=con.prepareStatement(sql);
			pst.setString(1, productName);
			rst=pst.executeQuery();
			if(rst.next()) {
				if(rst.getInt(1)>0) {
					throw new BusinessException("该商品已经存在");
				}
			}
//			sql = "SELECT class_id FROM Product_class WHERE class_name = ?";
//			pst=con.prepareStatement(sql);
//			pst.setString(1, className);
//			rst = pst.executeQuery();
//			while(rst.next()) {
//				classId = rst.getInt(1);
//				
//			}
			sql = "insert into Product_info(class_id,product_name,product_price,pref_price,number)values(?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setInt(1, classId);
			pst.setString(2, productName);
		    pst.setDouble(3, price);
		    pst.setDouble(4, prefPrice);
		    pst.setInt(5, number);
		    pst.execute();
			System.out.println("成功添加一个商品");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			DruidUtil.releaseSqlConnection(rst, pst, con);
		}
		return null;
	}

	@Override
	public void delet(BeanProductInfo product) throws BaseException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			connection = DruidUtil.getConnection();			
			String sql = "DELETE FROM Product_info WHERE product_id =?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1,product.getProductId());
			pst.execute();
			System.out.println("删除一种商品");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, connection);
		}
	}

	@Override
	public List<BeanProductInfo> loadAll(BeanProductClass productClass) throws BaseException {
		// TODO Auto-generated method stub
		List<BeanProductInfo> result=new ArrayList<BeanProductInfo>();
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rst =null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "SELECT * from Product_info where class_id = ?";
			st = connection.prepareStatement(sql);
			st.setInt(1, productClass.getClassId());
			rst = st.executeQuery();
			while(rst.next()) {
              BeanProductInfo product = new BeanProductInfo();
              product.setProductId(rst.getInt(1));
              product.setProductName(rst.getString(2));
              product.setProductPrice(rst.getDouble(3));
              product.setPrefPrice(rst.getDouble(4));
              result.add(product);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, st, connection);
		}
		return result;
	}

}
