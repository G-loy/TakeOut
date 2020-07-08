package cn.edu.zucc.take_out.itf;

import java.sql.Date;
import java.util.List;

import cn.edu.zucc.take_out.model.BeanRiderIncome;
import cn.edu.zucc.take_out.model.BeanRiderInfo;
import cn.edu.zucc.take_out.util.BaseException;


/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.itf
 * @date:2020年7月7日
 */
public interface IRiderIncomeManager {
	  public BeanRiderIncome add(int riderId,int orderId,Date time,String userEva,double income) throws BaseException;
	  public void delet(BeanRiderIncome income) throws BaseException;
	  public List<BeanRiderIncome> loadAll(BeanRiderInfo curRider) throws BaseException;
}
