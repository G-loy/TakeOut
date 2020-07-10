package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.zucc.take_out.itf.IOrderInfoManager;
import cn.edu.zucc.take_out.model.BeanOrderInfo;
import cn.edu.zucc.take_out.model.BeanProductInfo;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.DruidUtil;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月10日
 */
public class OrderManager implements IOrderInfoManager {

	@Override
	public BeanOrderInfo add(BeanProductInfo product,int number,boolean isCoup) throws BaseException {
		// TODO Auto-generated method stub
		Connection con  = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		BeanOrderInfo order = new BeanOrderInfo(); 
		try {
			con=DruidUtil.getConnection();
			String sql = "INSERT INTO order_info(product_id,number,money,per_discount)VALUES(?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, product.getProductId());
			pst.setInt(2,number);
			pst.setDouble(3,product.getProductPrice());
			if(isCoup==true) {
				pst.setDouble(4, product.getProductPrice()-product.getPrefPrice());
			}else {
				pst.setDouble(4, 0);
			}
			pst.execute();
			
			sql  = "SELECT * FROM order_info WHERE product_id = ? ";
			pst.setInt(1, product.getProductId());
			rst = pst.executeQuery();
			while (rst.next()) {
				order.setOrderId(rst.getInt(1));
				order.setProductId(rst.getInt(2));
				order.setNumber(rst.getInt(3));
				order.setMoney(rst.getDouble(4));
				order.setPerDiscount(rst.getDouble(5));
			}
			return order;	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, con);
		}
		return null;
	}

	@Override
	public void delet(BeanOrderInfo order) throws BaseException {
		// TODO Auto-generated method stub
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
        	con = DruidUtil.getConnection();
        	String sql = "DELET FROM order_info WHERE order_id = ?";
        	pst = con.prepareStatement(sql);
        	pst.setInt(1, order.getOrderId());
        	pst.execute();
        }catch(SQLException e) {
        	e.printStackTrace();
        }finally {
        	DruidUtil.releaseSqlConnection(rst, pst, con);
        }
	}

}
