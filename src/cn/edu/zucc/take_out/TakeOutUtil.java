package cn.edu.zucc.take_out;
/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out
 * @date:2020年7月4日
 */


import java.text.SimpleDateFormat;

import cn.edu.zucc.take_out.control.AddressManager;
import cn.edu.zucc.take_out.control.AdminManager;
import cn.edu.zucc.take_out.control.CouManager;
import cn.edu.zucc.take_out.control.ProductClassManager;
import cn.edu.zucc.take_out.control.ProductManager;
import cn.edu.zucc.take_out.control.RiderIncomeManager;
import cn.edu.zucc.take_out.control.RiderManager;
import cn.edu.zucc.take_out.control.ShopManager;
import cn.edu.zucc.take_out.control.UserManager;
import cn.edu.zucc.take_out.itf.IAddressManager;
import cn.edu.zucc.take_out.itf.IAdminManager;
import cn.edu.zucc.take_out.itf.ICouManager;
import cn.edu.zucc.take_out.itf.IProductClassManager;
import cn.edu.zucc.take_out.itf.IProductManager;
import cn.edu.zucc.take_out.itf.IRiderIncomeManager;
import cn.edu.zucc.take_out.itf.IRiderManager;
import cn.edu.zucc.take_out.itf.IShopManager;
import cn.edu.zucc.take_out.itf.IUserManager;

public class TakeOutUtil {
	
       public static IAdminManager adminManger  =  new AdminManager();
       public static IUserManager userManger = new UserManager();
       public static IShopManager shopManger = new ShopManager();
       public static IRiderManager riderManger =new RiderManager();
       public static ICouManager couManager = new CouManager();
       public static IProductClassManager productClaassManager = new ProductClassManager();
       public static IProductManager productManager = new ProductManager();
       public static IRiderIncomeManager riderIncomeManager =  new RiderIncomeManager();
       public static IAddressManager addressManager = new AddressManager();
       
       
       public static java.sql.Date strToDate(String strDate) {  
   		String str = strDate;  
   		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
   		java.util.Date d = null;  
   		try {  
   			d = format.parse(str);  
   		} catch (Exception e) {  
   			e.printStackTrace();  
   		}  
   		java.sql.Date date = new java.sql.Date(d.getTime());  
   		return date;  
   	}  
    
}
