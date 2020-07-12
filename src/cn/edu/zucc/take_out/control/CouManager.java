package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.take_out.itf.ICouManager;
import cn.edu.zucc.take_out.model.BeanCouInfo;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.DruidUtil;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月6日
 */
public class CouManager implements ICouManager {

	@Override
	public BeanCouInfo add(double coupMoney, int collRequest, Date StartTime, Date finishTime,String shopName) throws BaseException {
		// TODO Auto-generated method stub
		
		Connection connection =null;
		PreparedStatement st = null;
		ResultSet rs =null;
		
		int shopId = 0;
		
		try {
			connection =DruidUtil.getConnection();
			String sql = "SELECT shop_id FROM Shop_info WHERE shop_name = ?";
			st = connection.prepareStatement(sql);
			st.setString(1, shopName);
			rs = st.executeQuery();
			while(rs.next()) {
				shopId = rs.getInt(1);
			}
			sql = "insert into Cou_info(coup_money,coll_request,start_time,finish_time,shop_id)values(?,?,?,?,?)";
			st =connection.prepareStatement(sql);
			st.setDouble(1, coupMoney);
			st.setInt(2, collRequest);
			st.setDate(3, StartTime);
			st.setDate(4, finishTime);
			st.setInt(5, shopId);
			int count = st.executeUpdate();
			System.out.println("成功添加一类优惠券");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rs, st, connection);
		}
		return null;
	}

	@Override
	public void delet(BeanCouInfo cou) throws BaseException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "DELETE FROM Cou_info WHERE coup_id =?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1,cou.getCoupId());
			pst.execute();
			System.out.println("删除类优惠券");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, connection);
		}
		
	}
	@Override
	public List<BeanCouInfo> loadAll() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanCouInfo> result=new ArrayList<BeanCouInfo>();
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rst =null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "SELECT * from Cou_info";
			st = connection.prepareStatement(sql);
			rst = st.executeQuery();
			while(rst.next()) {
                BeanCouInfo coup = new BeanCouInfo();
                coup.setCoupId(rst.getInt(1));
                coup.setCoupMoney(rst.getDouble(2));
                coup.setCollRequest(rst.getInt(3));
                coup.setStartTime(rst.getDate(4));
                coup.setFinishTime(rst.getDate(5));
                coup.setShopId(rst.getInt(6));
                result.add(coup);
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
	public void changeCoup(BeanCouInfo coup) throws BaseException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rst =null;
		try {
			connection = DruidUtil.getConnection();
			String sql ="UPDATE Cou_info SET coup_money = ?,coll_request=?,start_time=?,finish_time=?,shop_id = ? WHERE coup_id = ?  ";
			st = connection.prepareStatement(sql);
            st.setDouble(1, coup.getCoupMoney());
            st.setInt(2, coup.getCollRequest());
            st.setDate(3, (java.sql.Date)coup.getStartTime());
            st.setDate(4, (java.sql.Date)coup.getFinishTime());
            st.setInt(5,coup.getCoupId());
            st.setInt(6, coup.getShopId());
            st.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, st, connection);
		}
	}



}
