package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cn.edu.zucc.take_out.itf.IUserManager;
import cn.edu.zucc.take_out.model.BeanAdminInfo;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.BusinessException;
import cn.edu.zucc.take_out.util.DruidUtil;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月4日
 */
public class UserManager implements IUserManager {

	@Override
	public BeanUserInfo login(String phoneNumber, String pwd) throws BaseException{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		BeanUserInfo  user = new BeanUserInfo();
		try {
			conn=DruidUtil.getConnection();
			String sql = "SELECT user_id,user_name,user_gender,user_pwd,user_phone,user_email,user_city,user_regist_time,is_member,member_ddl FROM User_info WHERE user_phone=?";
			pst=conn.prepareStatement(sql); 
			pst.setString(1, phoneNumber);
			rst=pst.executeQuery();
			if(!rst.next()) {
				throw new BusinessException(" 该用户不存在");
			}
			user.setUserId(rst.getInt(1));
			user.setUserName(rst.getString(2));
			user.setUserGender(rst.getString(3));
			user.setUserPwd(rst.getString(4));
			user.setUserPhone(rst.getString(5));
			user.setUserEmail(rst.getString(6));
			user.setUserCity(rst.getString(7));
			user.setUserRegistTime(rst.getDate(8));
			if(!user.getUserPwd().equals(pwd)) {
				throw new BusinessException("密码错误");
			}
			System.out.println("登陆成功");
			return user;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, conn);
		}
		return null;
	} 
	public BeanUserInfo regist(String phoneNumber,String pwd1,String pwd2) throws BaseException{
		if(phoneNumber == null) {
			throw new BusinessException("手机号为空");			
		}
		if(pwd1==null||pwd2==null) {
			throw new BusinessException("密码输入为空");
		}
		if(pwd1.compareTo(pwd2)!=0){
			throw new BusinessException("两次密码输入不一致");
		}

		Connection connection =null;
		PreparedStatement st = null;
		ResultSet rs =null;
		try {
			connection =DruidUtil.getConnection();
			String sql2 = "Select * from User_info where user_phone =?";
			st =connection.prepareStatement(sql2);
			st.setString(1, phoneNumber);
			rs = st.executeQuery();
			if (rs.next()) {
				throw new BusinessException("您的手机号已被注册");
			}
			String sql = "insert into User_info(user_phone,user_pwd,user_regist_time)values(?,?,now())";
			st =connection.prepareStatement(sql);
			st.setString(1, phoneNumber);
			st.setString(2, pwd1);
			st.executeUpdate();
			System.out.println("添加一位用户");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rs, st, connection);
		}
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BeanUserInfo regist(String name, String phoneNumber, String gender, Boolean ismember) throws BaseException {
		// TODO Auto-generated method stub
		Connection connection =null;
		PreparedStatement st = null;
		ResultSet rs =null;
		int is_number;
		Date member_ddl = null;
		try {
			connection =DruidUtil.getConnection();
			String sql2 = "Select * from User_info where user_phone =?";
			st =connection.prepareStatement(sql2);
			st.setString(1, phoneNumber);
			rs = st.executeQuery();
			if (rs.next()) {
				throw new BusinessException("您的手机号已被注册");
			}
			String sql ="insert into User_info(user_name,user_phone,user_gender,is_member,user_regist_time,member_ddl)values(?,?,?,?,now(),?)";
			st= connection.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, phoneNumber);
			st.setString(3, gender);

			if(ismember) {
				is_number=1;
				Calendar c = Calendar.getInstance();
				c.add(Calendar.DATE,30);
				member_ddl= new Date(c.getTimeInMillis());
			}else {
				is_number=0;
			}
			st.setInt(4, is_number);
			st.setDate(5, member_ddl);
			st.execute();
			System.out.println("通过管理员添加一位用户，请及时通知用户修改密码");
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rs, st, connection);
		}
		return null;
	}
	@Override
	public List<BeanUserInfo> loadAll() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanUserInfo> result=new ArrayList<BeanUserInfo>();
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rst =null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "SELECT * from User_info";
			st = connection.prepareStatement(sql);
			rst = st.executeQuery();
			while(rst.next()) {
				BeanUserInfo user = new BeanUserInfo();
				user.setUserId(rst.getInt(1));
				user.setUserName(rst.getString(2));
				user.setUserGender(rst.getString(3));
				user.setUserPwd(rst.getString(4));
				user.setUserPhone(rst.getString(5));
				user.setUserEmail(rst.getString(6));
				user.setUserCity(rst.getString(7));
				user.setUserRegistTime(rst.getDate(8));
				user.setIsMember(rst.getInt(9)==0?false:true);
				user.setMemberDDL(rst.getDate(10));
				result.add(user);
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
	public void delete(BeanUserInfo user) throws BaseException {
		// TODO Auto-generated method stub		
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "DELETE FROM User_info WHERE user_id =?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1,user.getUserId());
			pst.execute();
			System.out.println("删除一条用户");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, connection);
		}

	}
	@Override
	public BeanUserInfo changeInfo(BeanUserInfo user) throws BaseException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			connection=DruidUtil.getConnection();
			String sql = "UPDATE User_info SET user_name=?,user_gender=?,user_phone=?,user_email=?,user_city=? WHERE user_id=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, String.valueOf(user.getUserName()));
			pst.setString(2, String.valueOf(user.getUserGender()));
			pst.setString(3, String.valueOf(user.getUserPhone()));
			pst.setString(4, String.valueOf(user.getUserEmail()));
			pst.setString(5, String.valueOf(user.getUserCity()));
			pst.setInt(6, user.getUserId());
			pst.execute();
			return user;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
		    DruidUtil.releaseSqlConnection(rst, pst, connection);
		}
		return null;
	}
	@Override
	public void changePwd(BeanUserInfo user, String oldPwd, String newPwd1, String newPwd2)
			throws BaseException {
		// TODO Auto-generated method stub
		Connection connection  = null;
		PreparedStatement st =null;
		if(oldPwd==null||newPwd1==null||newPwd2==null){
			throw new BusinessException("输入不得为空");
		}
		if(oldPwd.compareTo(user.getUserPwd())!=0) {
			throw new BusinessException("原密码错误");
		}
		if (newPwd1.compareTo(newPwd2)!=0) {
			throw new BusinessException("两次密码不相同");
		}
		try {
			connection = DruidUtil.getConnection();
			String sql = "UPDATE User_info SET user_pwd = ? where user_id = ?";
			st =connection.prepareStatement(sql);
			st.setString(1, newPwd1);
			st.setInt(2, user.getUserId());
			int count = st.executeUpdate();
			System.out.println("更新记录"+count+"条");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(null, st, connection);
		}
	}
	

}







