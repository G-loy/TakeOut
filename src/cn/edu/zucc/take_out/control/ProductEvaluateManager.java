package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.zucc.take_out.model.BeanProductOrder;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.BusinessException;
import cn.edu.zucc.take_out.util.DruidUtil;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月11日
 */
public class ProductEvaluateManager implements IProductEvaluateManager {

	@Override
	public void evaluate(BeanProductOrder productOrder, String details, int star) throws BaseException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		int productId = 0;
		if(productOrder.getState().compareTo("已送达")!=0) {
			throw new BusinessException("该商品还未确认收货");
		}
		try {
			con =DruidUtil.getConnection();
			String sql = "SELECT product_id FROM order_info WHERE order_id = ?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, productOrder.getOrderId());
			rst =pst.executeQuery();
			while(rst.next()) {
				productId = rst.getInt(1);
			}
			System.out.println(productOrder.getOrderId());
			System.out.print(productId);
		    sql = "INSERT INTO Product_evaluate_info(user_id,product_id,shop_id,details,date,star)VALUES(?,?,?,?,now(),?)";
		    pst=con.prepareStatement(sql);
		    pst.setInt(1, productOrder.getUserId());
		    pst.setInt(2, productId);
		    pst.setInt(3, productOrder.getShopId());
		    pst.setString(4, details);
		    pst.setInt(5, star);
		    pst.execute();
            System.out.println("成功评价");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, con);
		}
		 
	}
     
}














