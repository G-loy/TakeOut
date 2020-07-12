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
	public BeanOrderInfo add(int orderId,BeanProductInfo product,int number,boolean isCoup) throws BaseException {
		// TODO Auto-generated method stub
		Connection con  = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		BeanOrderInfo order = new BeanOrderInfo(); 
		try {
			con=DruidUtil.getConnection();
			String sql = "INSERT INTO order_info(order_id,product_id,number,money,per_discount)VALUES(?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, orderId);
			pst.setInt(2, product.getProductId());
			pst.setInt(3,number);
			pst.setDouble(4,product.getProductPrice());
			if(isCoup==true) {
				pst.setDouble(5, product.getProductPrice()-product.getPrefPrice());
			}else {
				pst.setDouble(5, 0);
			}
			pst.execute();
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
