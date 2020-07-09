package cn.edu.zucc.take_out.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.take_out.itf.IAddressManager;
import cn.edu.zucc.take_out.model.BeanAddress;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.BusinessException;
import cn.edu.zucc.take_out.util.DruidUtil;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月8日
 */
public class AddressManager implements IAddressManager {

	@Override
	public BeanAddress addAddress(int userId, String province, String city, String distance, String address,
			String linkman, String phonenumber) throws BaseException {
		// TODO Auto-generated method stub
		if(province==null||city==null||distance==null||linkman==null||phonenumber==null) {
			throw new BusinessException("输入信息不完整");
		}
		Connection connection =null;
		PreparedStatement st = null;
		ResultSet rs =null;
		try {
			connection =DruidUtil.getConnection();
			String sql = "insert into Address(user_id,province,city,distance,address,linkman,phonenumber)values(?,?,?,?,?,?,?)";
			st =connection.prepareStatement(sql);
			st.setInt(1, userId);
			st.setString(2, province);
			st.setString(3, city);
			st.setString(4, distance);
			st.setString(5, address);
			st.setString(6, linkman);
			st.setString(7, phonenumber);
	        st.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DruidUtil.releaseSqlConnection(rs, st, connection);
		}
		return null;
	}

	@Override
	public void deletAddress(BeanAddress address) throws BaseException {
		// TODO Auto-generated method stub
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        if (address==null) {
        	throw new BusinessException("为选中有效序列");
        }        
        try {
     	   
     	   connection = DruidUtil.getConnection();
     	   String sql = "DELETE FROM Address WHERE address_id =?";
     	   pst = connection.prepareStatement(sql);
     	   pst.setInt(1,address.getAddressId());
     	   pst.execute();
     	   System.out.println("删除一条配送地址");
        }catch(SQLException e) {
     	   e.printStackTrace();
        }finally {
     	   DruidUtil.releaseSqlConnection(rst, pst, connection);
        }
     
	}

	@Override
	public List<BeanAddress> loadAll() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanAddress> result=new ArrayList<BeanAddress>();
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rst =null;
		try {
			connection = DruidUtil.getConnection();
			String sql = "SELECT * from Address";
			st = connection.prepareStatement(sql);
			rst = st.executeQuery();
			while(rst.next()) {
				BeanAddress addressInfo=new BeanAddress();
                 addressInfo.setAddressId(rst.getInt(1));
                 addressInfo.setUserId(rst.getInt(2));
                 addressInfo.setProvince(rst.getString(3));
                 addressInfo.setCity(rst.getString(4));
                 addressInfo.setDistance(rst.getString(5));
                 addressInfo.setAddress(rst.getString(6));
                 addressInfo.setLinkman(rst.getString(7));
                 addressInfo.setPhoneNumber(rst.getString(8));
				result.add(addressInfo);
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
