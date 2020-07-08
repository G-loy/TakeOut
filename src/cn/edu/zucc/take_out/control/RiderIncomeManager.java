package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.take_out.itf.IRiderIncomeManager;
import cn.edu.zucc.take_out.model.BeanRiderIncome;
import cn.edu.zucc.take_out.model.BeanRiderInfo;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.DruidUtil;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月7日
 */
public class RiderIncomeManager implements IRiderIncomeManager {

	@Override
	public BeanRiderIncome add(int riderId,int orderId,Date time,String userEva,double income) throws BaseException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rst =null;
	try {
		con=DruidUtil.getConnection();
		String sql = "insert into Rider_income(rider_id,order_id,time,userEva,income)values(?,?,?,?,?)";
		pst=con.prepareStatement(sql);
		pst.setInt(1, riderId);
		pst.setInt(2, orderId);
	    pst.setDate(3, time);
	    pst.setString(4,userEva);
	    pst.setDouble(5, income);
	    pst.execute();
		System.out.println("成功添加一张骑手收入账单");
	}catch(SQLException e) {
		e.printStackTrace();
	}finally{
		DruidUtil.releaseSqlConnection(rst, pst, con);
	}
	return null;
	}

	@Override
	public void delet(BeanRiderIncome income) throws BaseException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			connection = DruidUtil.getConnection();			
			String sql = "DELETE FROM Rider_income WHERE rider_income_id =?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1,income.getRiderIncomeId());
			pst.execute();
			System.out.println("删除一张骑手入账单");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, connection);
		}
	}

	@Override
	public List<BeanRiderIncome> loadAll(BeanRiderInfo rider) throws BaseException {
		// TODO Auto-generated method stub
		List<BeanRiderIncome> result=new ArrayList<BeanRiderIncome>();
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rst =null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "SELECT * from Rider_income where rider_id = ?";
			st = connection.prepareStatement(sql);
			st.setInt(1, rider.getRiderId());
			rst = st.executeQuery();
			while(rst.next()) {
              BeanRiderIncome income = new BeanRiderIncome();
              income.setRiderIncomeId(rst.getInt(1));
              income.setRiderId(rst.getInt(2));
              income.setTime(rst.getDate(3));
              income.setUserEval(rst.getString(4));
              income.setIncome(rst.getDouble(5));
              result.add(income);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, st, connection);
		}
		return result;
	}

}
