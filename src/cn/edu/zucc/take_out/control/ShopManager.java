package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.take_out.itf.IShopManager;
import cn.edu.zucc.take_out.model.BeanShopInfo;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.BusinessException;
import cn.edu.zucc.take_out.util.DruidUtil;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月5日
 */
public class ShopManager implements IShopManager{

	@Override
	public BeanShopInfo regist(String shopName, int star) throws BaseException {
		// TODO Auto-generated method stub
			
		    Connection connection =null;
			PreparedStatement st = null;
			ResultSet rs =null;
			try {
		     connection =DruidUtil.getConnection();
		     String sql2 = "Select * from Shop_info where shop_name=?";
		     st =connection.prepareStatement(sql2);
		     st.setString(1, shopName);
		     rs = st.executeQuery();
		     if (rs.next()) {
		    	 throw new BusinessException("该商家名已被注册");
		     }
		     String sql = "insert into Shop_info(shop_name,shop_star)values(?,?)";
		     st =connection.prepareStatement(sql);
		     st.setString(1, shopName);
		     st.setInt(2, star);
		     st.executeUpdate();
		     System.out.println("成功添加一户商家");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DruidUtil.releaseSqlConnection(rs, st, connection);
			}
			// TODO Auto-generated method stub
			return null;
	}

	@Override
	public List<BeanShopInfo> loadAll() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanShopInfo> result=new ArrayList<BeanShopInfo>();
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rst =null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "SELECT * from Shop_info";
			st = connection.prepareStatement(sql);
			rst = st.executeQuery();
			while(rst.next()) {
			   BeanShopInfo shop = new BeanShopInfo();
			   shop.setShopId(rst.getInt(1));
			   shop.setShopName(rst.getString(2));
			   shop.setShopStar(rst.getInt(3));
			   shop.setConAvg(rst.getDouble(4));
			   shop.setTotalSale(rst.getDouble(5));
               result.add(shop);			
			}
			System.out.println(result.size());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, st, connection);
		}
		return result;
	}

	@Override
	public void delete(BeanShopInfo shop) throws BaseException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "DELETE FROM Shop_info WHERE shop_id =?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1,shop.getShopId());
			pst.execute();
			System.out.println("删除一位商家");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, connection);
		}
	}

	@Override
	public List<String> loadAllName() throws BaseException {
		// TODO Auto-generated method stub
		List<String> result=new ArrayList<String>();
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rst =null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "SELECT shop_name from Shop_info";
			st = connection.prepareStatement(sql);
			rst = st.executeQuery();
			while(rst.next()) {
			  String shopName = rst.getString(1);
			  
               result.add(shopName);			
			}
			System.out.println(result.size());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, st, connection);
		}
		return result;
	}

}
