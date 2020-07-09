package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.take_out.itf.IMJPlanManager;
import cn.edu.zucc.take_out.model.BeanCouInfo;
import cn.edu.zucc.take_out.model.BeanMjPlan;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.DruidUtil;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月9日
 */
public class MJPlanManager implements IMJPlanManager {

	@Override
	public BeanMjPlan addPlan(String shopName,Double mjMoney, Double discantMoney, boolean canADD) throws BaseException {
		// TODO Auto-generated method stub
		int shopId = 0;
		Connection connection =null;
		PreparedStatement st = null;
		ResultSet rs =null;
		
		try {
			connection =DruidUtil.getConnection();
			String sql = "SELECT shop_id FROM Shop_info WHERE shop_name = ?";
			st = connection.prepareStatement(sql);
			st.setString(1, shopName);
			rs = st.executeQuery();
			while(rs.next()) {
				shopId = rs.getInt(1);
			}
			sql = "insert into Mj_plan(shop_id,mj_money,discount_money,can_add)values(?,?,?,?)";
		    st=connection.prepareStatement(sql);
		    st.setInt(1, shopId);
		    st.setDouble(2, mjMoney);
		    st.setDouble(3, discantMoney);
		    if(canADD==true) {
		    	st.setInt(4, 1);
		    }else {
		    	st.setInt(4, 0);
		    }
			int count = st.executeUpdate();
			System.out.println("成功添加一类满减计划");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rs, st, connection);
		}
		return null;
	}

	@Override
	public List<BeanMjPlan> loadAll() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanMjPlan> result=new ArrayList<BeanMjPlan>();
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rst =null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "SELECT * from Mj_plan";
			st = connection.prepareStatement(sql);
			rst = st.executeQuery();
			while(rst.next()) {
                BeanMjPlan coup = new BeanMjPlan();
                coup.setMjID(rst.getInt(1));
                coup.setShop_Id(rst.getInt(2));
                coup.setMjMoney(rst.getDouble(3));
                coup.setDicountMoney(rst.getDouble(4));
                if(rst.getInt(5)==1) {
                	coup.setCanADD(true);
                }else {
                	coup.setCanADD(false);
                }
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
	public void deletPlan(BeanMjPlan mjPlan) throws BaseException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "DELETE FROM Mj_plan WHERE mj_id =?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1,mjPlan.getMjID());
			pst.execute();
			System.out.println("删除一种满减计划");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, connection);
		}
		
	}

	@Override
	public void changePlan(BeanMjPlan plan) throws BaseException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			connection = DruidUtil.getConnection();
			String sql ="UPDATE Mj_plan SET mj_money = ?,discount_money=?,can_add=? WHERE mj_id = ? ";
			pst = connection.prepareStatement(sql);
			pst.setDouble(1, plan.getMjMoney());
			pst.setDouble(2, plan.getDicountMoney());
			if(plan.isCanADD()==true) {
				pst.setInt(3, 1);
			}else {
				pst.setInt(3, 0);
			}
			pst.setInt(4, plan.getMjID());
			
			pst.execute();
		}catch(SQLException e){
			
		}
		
	}

}
