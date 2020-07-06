package cn.edu.zucc.take_out.util ;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: util
 * @date:2020年6月28日
 */
public class DruidUtil {
	
        private DruidUtil() {}
            
       private static DataSource dataSource;
       
       //加载配置文件
       static {
    	   	InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
    	   	Properties properties  = new Properties();
    	    try {
    	    	properties.load(inStream);
    	    	dataSource = DruidDataSourceFactory.createDataSource(properties);
    	    	
    	    }catch(Exception e){
    	    	e.printStackTrace();
    	    }
    	   	
       }
       
       // 初始化数据库链接
       /**
        * 
        * @return 数据库链接事例 connection
        */
       public static Connection getConnection() {
    	   try {
    		   return dataSource.getConnection();
    	   }catch(SQLException e) {
    		   e.printStackTrace();
    	   }
    	   throw new RuntimeException("数据库链接异常");
       }
       
       
       /**
        *  释放数据库链接connection 到数据库缓存池，并关闭 rt 和 pt 资源
        *  @param st 数据库处理结果集
        *  @param pt 数据库操作语句
        *  @param connection 数据库链接对象
        */
        public static void releaseSqlConnection(ResultSet st,PreparedStatement pt,Connection connection) {
        	try {
        		if(st !=null) {
        			st.close();
        		}
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}finally {
        		try {
        			if(pt !=null) {
        				pt.close();
        			}
        		}catch(SQLException e) {
        			e.printStackTrace();
        		}finally {
        			try {
        				if(connection != null) {
        					connection.close();
        				}
        			} catch(SQLException e){
        				e.printStackTrace();
        			}
        		}
        	}
        }
       
       
       

        
       
}



























