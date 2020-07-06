package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.take_out.itf.IAdminManager;
import cn.edu.zucc.take_out.model.BeanAdminInfo;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.BusinessException;
import cn.edu.zucc.take_out.util.DruidUtil;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月4日
 */
public class AdminManager implements IAdminManager {

	@Override
	public BeanAdminInfo login(String name, String pwd)throws BaseException {
		// TODO Auto-generated method stub
		System.out.println(name);
		System.out.println(pwd);
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		BeanAdminInfo admin = new BeanAdminInfo();
		try {
			conn=DruidUtil.getConnection();
			String sql = "SELECT adm_id,adm_name,adm_password FROM Admin_info WHERE  adm_name=?";
			pst=conn.prepareStatement(sql); 
			pst.setString(1, name);
			rst=pst.executeQuery();
			if(!rst.next()) {
				throw new BusinessException(" 该管理员账户不存在");
			}
			admin.setAdmId(rst.getInt(1));
			admin.setAdmName(rst.getString(2));
			admin.setAdmPassword(rst.getString(3));
			if(!admin.getAdmPassword().equals(pwd)) {
				throw new BusinessException("密码错误");
			}
			System.out.println("登陆成功");
			return admin;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, conn);
		}
		return null;
	}

	@SuppressWarnings("resource")
	@Override
	public BeanAdminInfo add(String name, String pwd1, String pwd2) throws BaseException {
		// TODO Auto-generated method stub

		if(name == null) {
			throw new BusinessException("账户名为空");			
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
			connection = DruidUtil.getConnection();
			String sql2 = "Select * from Admin_info where adm_name =?";
			st =connection.prepareStatement(sql2);
			st.setString(1, name);
			rs = st.executeQuery();
			if (rs.next()) {
				throw new BusinessException("该管理员账户名已存在");
			}
			String sql = "insert into Admin_info(adm_name,adm_password)values(?,?)";
			st =connection.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, pwd1);
			@SuppressWarnings("unused")
			int count = st.executeUpdate();
			System.out.println("添加了一位管理员");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rs, st, connection);
		}
		// TODO Auto-generated method stub
		    return null;
	}

	@Override
	public List<BeanAdminInfo> loadAll() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanAdminInfo> result=new ArrayList<BeanAdminInfo>();
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rst =null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "SELECT * from Admin_info";
			st = connection.prepareStatement(sql);
			rst = st.executeQuery();
			while(rst.next()) {
				BeanAdminInfo admin=new BeanAdminInfo();
                admin.setAdmId(rst.getInt(1));
                admin.setAdmName(rst.getString(2));
                admin.setAdmPassword(rst.getString(3));
				result.add(admin);
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
	public void deleteAdmin(BeanAdminInfo admin) throws BaseException {
		// TODO Auto-generated method stub
           Connection connection = null;
           PreparedStatement pst = null;
           ResultSet rst = null;
           try {
        	   if(admin.getAdmId()==1) {
        		   throw new BusinessException("无法删除root权限");
        	   }
        	   if(admin.getAdmId()==BeanAdminInfo.currentLoginAdmin.getAdmId()) {
        		   throw new BusinessException("无法删除当前登陆的管理员账户");
        	   }
        	   
        	   connection = DruidUtil.getConnection();
        	   String sql = "DELETE FROM Admin_info WHERE adm_id =?";
        	   pst = connection.prepareStatement(sql);
        	   pst.setInt(1,admin.getAdmId());
        	   pst.execute();
        	   System.out.println("删除一条管理员账户");
           }catch(SQLException e) {
        	   e.printStackTrace();
           }finally {
        	   DruidUtil.releaseSqlConnection(rst, pst, connection);
           }
           
	}

	@Override
	public void changePwd(BeanAdminInfo admin, String oldPwd, String newPwd1, String newPwd2) throws BusinessException {
		// TODO Auto-generated method stub
		Connection connection  = null;
		PreparedStatement st =null;
		if(oldPwd==null||newPwd1==null||newPwd2==null){
			throw new BusinessException("输入不得为空");
		}
		if(oldPwd.compareTo(admin.getAdmPassword())!=0) {
			throw new BusinessException("原密码错误");
		}
		if (newPwd1.compareTo(newPwd2)!=0) {
			throw new BusinessException("两次密码不相同");
		}
		try {
			connection = DruidUtil.getConnection();
			String sql = "UPDATE Admin_info SET adm_password = ? where adm_id = ?";
			st =connection.prepareStatement(sql);
			st.setString(1, newPwd1);
			st.setInt(2, admin.getAdmId());
			int count = st.executeUpdate();
			System.out.println("更新管理员密码"+count+"条");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(null, st, connection);
		}

	}
}



















