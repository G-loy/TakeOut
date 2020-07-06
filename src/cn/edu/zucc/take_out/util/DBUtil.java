package cn.edu.zucc.take_out.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String jdbcUrl="jdbc:mysql://localhost:3306/personal_plan?useSSL=false&allowPublicKeyRetrieval=true&GMT%2B8characterEncoding=utf-8";
	private static final String dbUser="root";
	private static final String dbPwd="Gg13506800412";
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws java.sql.SQLException{
		return java.sql.DriverManager.getConnection(jdbcUrl, dbUser, dbPwd);
	}
	public static void free(ResultSet rs,Statement st,Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(st!=null) {
					st.close();
				}
			 }catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn!=null) {
						conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
