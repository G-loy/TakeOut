package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.take_out.itf.IRiderManager;
import cn.edu.zucc.take_out.model.BeanRiderInfo;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.DruidUtil;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月5日
 */
public class RiderManager implements IRiderManager {

	@Override
	public BeanRiderInfo regist(String name, int star) throws BaseException {
		Connection connection =null;
		PreparedStatement st = null;
		ResultSet rs =null;
		try {
			connection =DruidUtil.getConnection();
			String sql = "insert into Rider_info(rider_name,rider_sta,board_date)values(?,?,now())";
			st =connection.prepareStatement(sql);
			st.setString(1, name);
			st.setInt(2, star);
			st.executeUpdate();
			System.out.println("成功添加一位骑手");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rs, st, connection);
		}
		return null;
	}

	@Override
	public void delete(BeanRiderInfo rider) throws BaseException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "DELETE FROM Rider_info WHERE rider_id =?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1,rider.getRiderId());
			pst.execute();
			System.out.println("删除一位骑手");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, connection);
		}
	}

	@Override
	public List<BeanRiderInfo> loadAll() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanRiderInfo> result=new ArrayList<BeanRiderInfo>();
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rst =null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "SELECT * from Rider_info";
			st = connection.prepareStatement(sql);
			rst = st.executeQuery();
			while(rst.next()) {
                BeanRiderInfo rider = new BeanRiderInfo();
                rider.setRiderId(rst.getInt(1));
                rider.setRiderName(rst.getString(2));
                rider.setBoardDate(rst.getDate(3));
                rider.setRiderSta(rst.getInt(4));
                result.add(rider);
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
