package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.zucc.take_out.itf.IProductOrderManager;
import cn.edu.zucc.take_out.model.BeanAddress;
import cn.edu.zucc.take_out.model.BeanProductInfo;
import cn.edu.zucc.take_out.model.BeanProductOrder;
import cn.edu.zucc.take_out.model.BeanRiderInfo;
import cn.edu.zucc.take_out.model.BeanUserHasCouInfo;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.DruidUtil;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月10日
 */
public class ProdectOrderManager implements IProductOrderManager{

	@Override
	public BeanProductOrder add(BeanProductInfo product, BeanUserInfo user, BeanRiderInfo rider,
			BeanUserHasCouInfo userHasCouInfo, Date time, BeanAddress address, String state) throws BaseException {
		// TODO Auto-generated method stub


		Connection conn =null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		int coup_id = 0;
		int mj_id = 0;
		try {
			conn=DruidUtil.getConnection();
			
			String sql = "SELECT coup_id FROM User_has_Cou_info WHERE user_id = ? AND shop_id = ? AND number > 0";
			pst= conn.prepareStatement(sql);
			pst.setInt(1, BeanUserInfo.currentLoginUser.getUserId());
			pst.setInt(2, product.getShop_id());
			rst=pst.executeQuery();
			while(rst.next()) {
				coup_id=rst.getInt(1);
			}
			
			
			
			
			sql = "INSERT INTO Product_order(shop_id,address_id,user_id,mj_id,rider_id,coup_id,org_money,finally_money,order_time,service_time)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, product.getShop_id());
			pst.setInt(2, address.getAddressId());
			pst.setInt(3, BeanUserInfo.currentLoginUser.getUserId());
			
			

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}























