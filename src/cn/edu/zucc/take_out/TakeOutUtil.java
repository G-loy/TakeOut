package cn.edu.zucc.take_out;
/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out
 * @date:2020年7月4日
 */

import cn.edu.zucc.take_out.control.AdminManager;
import cn.edu.zucc.take_out.control.RiderManager;
import cn.edu.zucc.take_out.control.ShopManager;
import cn.edu.zucc.take_out.control.UserManager;
import cn.edu.zucc.take_out.itf.IAdminManager;
import cn.edu.zucc.take_out.itf.IRiderManager;
import cn.edu.zucc.take_out.itf.IShopManager;
import cn.edu.zucc.take_out.itf.IUserManager;

public class TakeOutUtil {
       public static IAdminManager adminManger  =  new AdminManager();
       public static IUserManager userManger = new UserManager();
       public static IShopManager shopManger = new ShopManager();
       public static IRiderManager riderManger =new RiderManager();
}
