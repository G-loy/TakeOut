package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.take_out.itf.IUserHasCouInfoManager;
import cn.edu.zucc.take_out.model.BeanUserHasCouInfo;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.DruidUtil;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月9日
 */
public class UserHasCouInfoManager implements IUserHasCouInfoManager {

	@Override
	public List<BeanUserHasCouInfo> loadAllbyUserId(BeanUserInfo user) throws BaseException {
		// TODO Auto-generated method stub
		List<BeanUserHasCouInfo> result = new ArrayList<BeanUserHasCouInfo>();
		Connection con = null;
		PreparedStatement  pst = null;
		ResultSet rst = null;

		try {
			con = DruidUtil.getConnection();
			String sql = "SELECT * from User_has_Cou_info where user_id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1,user.getUserId());
			rst=pst.executeQuery();
			while(rst.next()) {
				BeanUserHasCouInfo buhci = new BeanUserHasCouInfo();
				buhci.setUserId(rst.getInt(1));
				buhci.setCouId(rst.getInt(2));
				buhci.setShopId(rst.getInt(3));
				buhci.setDiscountMoney(rst.getDouble(4));
				buhci.setNumber(rst.getInt(5));
				buhci.setDdl(rst.getDate(6));
				result.add(buhci);
				System.out.print(buhci.getDdl());
			}
			System.out.println("已经刷新用户持有的优惠券");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, con);
		}
		return result;
	}

	@Override
	public void delet(BeanUserHasCouInfo ubhci) throws BaseException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			connection = DruidUtil.getConnection();			
			String sql = "DELETE FROM User_has_Cou_info WHERE user_id =?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1,ubhci.getUserId());
			pst.execute();
			System.out.println("删除一类持有的优惠券");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, connection);
		}

	}

	@Override
	public void add(BeanUserHasCouInfo ubhci) throws BaseException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rst =null;
		try {
			con=DruidUtil.getConnection();
			String sql = "insert into User_has_Cou_info(user_id,cou_id,shop_id,Discount_money,number,ddl)values(?,?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setInt(1, ubhci.getUserId());
			pst.setInt(2, ubhci.getCouId());
			pst.setInt(3, ubhci.getShopId());
			pst.setDouble(4,ubhci.getDiscountMoney());
			pst.setInt(5,ubhci.getNumber());
			pst.setDate(5, (Date) ubhci.getDdl());
			pst.execute();
			System.out.println("成功添加一优惠券");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			DruidUtil.releaseSqlConnection(rst, pst, con);
		}
	}

}
