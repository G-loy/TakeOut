package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.take_out.itf.IProductClassManager;
import cn.edu.zucc.take_out.model.BeanCouInfo;
import cn.edu.zucc.take_out.model.BeanProductClass;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.BusinessException;
import cn.edu.zucc.take_out.util.DruidUtil;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月7日
 */
public class ProductClassManager implements IProductClassManager {

	@Override
	public BeanProductClass add(String className) throws BaseException {
		// TODO Auto-generated method stub
		Connection connection =null;
		PreparedStatement st = null;
		ResultSet rs =null;
		try {
			connection =DruidUtil.getConnection();
			String sql = "SELECT count(*) from Product_class WHERE class_name = ?";
			st=connection.prepareStatement(sql);
			st.setString(1, className);
			rs=st.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)>0) {
					throw new BusinessException("该商品类已经存在");
				}
			}
			
			sql = "insert into Product_class(class_name)values(?)";
			st =connection.prepareStatement(sql);
			st.setString(1, className);
			int count = st.executeUpdate();
			System.out.println("成功添加一个商品类");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rs, st, connection);
		}
		return null;
	}

	@Override
	public void delet(BeanProductClass productClass) throws BaseException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		try {
			connection = DruidUtil.getConnection();
			
			String sql = "SELECT count(*) from Product_info WHERE class_id = ?";
			pst=connection.prepareStatement(sql);
			pst.setInt(1, productClass.getClassId());
			rst=pst.executeQuery();
			if(rst.next()) {
				if(rst.getInt(1)>0) {
					throw new BusinessException("该商品类存在商品，无法删除");
				}
			}
			
			sql = "DELETE FROM Product_class WHERE class_id =?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1,productClass.getClassId());
			pst.execute();
			System.out.println("删除一类商品");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, pst, connection);
		}
		
	}

	@Override
	public List<BeanProductClass> loadAll() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanProductClass> result=new ArrayList<BeanProductClass>();
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rst =null;
		try {
			connection = DruidUtil.getConnection();


			String 	sql = "SELECT * from Product_class";
			st = connection.prepareStatement(sql);
			rst = st.executeQuery();
			while(rst.next()) {
               BeanProductClass productClass = new BeanProductClass();
               productClass.setClassId(rst.getInt(1));
               productClass.setClassName(rst.getString(2));
               productClass.setProductNumber(rst.getInt(3));
               result.add(productClass);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, st, connection);
		}
		return result;
	}

	@Override
	public List<String> getAllClassName() throws BaseException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rst =null;
		List<String> result = new ArrayList<String>();
		try {
			connection = DruidUtil.getConnection();
			String sql = "SELECT class_name FROM Product_class";
			st = connection.prepareStatement(sql);
			rst = st.executeQuery();
			
			while(rst.next()) {
				result.add(rst.getString(1));
			}
			System.out.println(result.toString());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rst, st, connection);
		}	
		return result;
	}

}
