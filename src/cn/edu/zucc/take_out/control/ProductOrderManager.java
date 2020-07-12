package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

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
public class ProductOrderManager implements IProductOrderManager{

	@Override
	public BeanProductOrder add(BeanProductInfo product, BeanUserInfo user, int mjId, int coupId, int addressId,
			double orgMoney,double finalMoney,Date serviceTime, String state) throws BaseException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		int riderId=0;
		BeanProductOrder productor = new BeanProductOrder();

		try {
			con=DruidUtil.getConnection();
			String sql ="SELECT rider_id FROM Rider_info LIMIT 1";
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next()) {
				riderId = rst.getInt(1);
			}
			sql = "INSERT INTO Product_order(shop_id,address_id,user_id,mj_id,rider_id,coup_id,org_money,finally_money,order_time,service_time,state)VALUES(?,?,?,?,?,?,?,?,now(),?,?)";
			pst=con.prepareStatement(sql,pst.RETURN_GENERATED_KEYS);
			pst.setInt(1, product.getShop_id());
			pst.setInt(2, addressId);
			pst.setInt(3, user.getUserId());
			pst.setInt(4, mjId);
			pst.setInt(5, riderId);
			pst.setInt(6, coupId);
			pst.setDouble(7,orgMoney);
			pst.setDouble(8, finalMoney);
			pst.setDate(9,serviceTime);
			pst.setString(10, state);
			pst.executeUpdate();

			rst=pst.getGeneratedKeys();
			if(rst.next()) {
				productor.setOrderId(rst.getInt(1));
			}
			productor.setShopId(product.getShop_id());
			productor.setAddressId(addressId);
			productor.setUserId(user.getUserId());
			productor.setMjId(mjId);
			productor.setRiderId(riderId);
			productor.setCoupId(coupId);
			productor.setOrgMoney(orgMoney);
			productor.setFinallyMoney(finalMoney);
			productor.setServiceTime(serviceTime);
			productor.setDrderTime(new Date(System.currentTimeMillis()));
			productor.setState(state);
			return productor;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, con);
		}

		return null;
	}

	@Override
	public List<BeanProductOrder> loadALL(BeanUserInfo user) throws BaseException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		List<BeanProductOrder> result = new ArrayList<BeanProductOrder>();
		try {
			con=DruidUtil.getConnection();
			String sql = "SELECT * FROM Product_order WHERE user_id = ? ";
			pst = con.prepareStatement(sql);
			pst.setInt(1, user.getUserId());
			rst = pst.executeQuery();
			while(rst.next()) {
				BeanProductOrder productOrder  = new BeanProductOrder();
				productOrder.setOrderId(rst.getInt(1));
				productOrder.setShopId(rst.getInt(2));
				productOrder.setAddressId(rst.getInt(3));
				productOrder.setUserId(rst.getInt(4));
				productOrder.setMjId(rst.getInt(5));
				productOrder.setRiderId(rst.getInt(6));
				productOrder.setCoupId(rst.getInt(7));
				productOrder.setOrgMoney(rst.getDouble(8));
				productOrder.setFinallyMoney(rst.getDouble(9));
				productOrder.setServiceTime(rst.getDate(10));
				productOrder.setDrderTime(rst.getDate(11));
				productOrder.setState(rst.getString(12));
				result.add(productOrder);
			}
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, con);
		}


		return null;
	}

	@Override
	public void receive(BeanProductOrder productOrder) throws BaseException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			con = DruidUtil.getConnection();
			String sql = "UPDATE Product_order SET state=? WHERE order_id = ?";
			pst= con.prepareStatement(sql);
			pst.setString(1, "已送达");
			pst.setInt(2, productOrder.getOrderId());
			pst.execute();
		}catch(SQLException e) {
			e.printStackTrace();
	    }finally{
	    	DruidUtil.releaseSqlConnection(rst, pst, con);
	    }
	}

}























