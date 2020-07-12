package cn.edu.zucc.take_out.itf;
/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.itf
 * @date:2020年7月10日
 */

import java.sql.Date;
import java.util.List;


import cn.edu.zucc.take_out.model.BeanProductInfo;
import cn.edu.zucc.take_out.model.BeanProductOrder;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;

public interface IProductOrderManager {
	public BeanProductOrder add(BeanProductInfo product,BeanUserInfo user,int mjId,int coupId,int addressId,double orgMoney,double finalMoney,Date serviceTime,String state) throws BaseException;
	public List<BeanProductOrder> loadALL(BeanUserInfo user)throws BaseException; 
	public void receive(BeanProductOrder productOrder) throws BaseException;
}
