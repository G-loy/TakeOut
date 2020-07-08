package cn.edu.zucc.take_out.itf;

import java.sql.Date;
import java.util.List;

import cn.edu.zucc.take_out.model.BeanCouInfo;
import cn.edu.zucc.take_out.util.BaseException;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.itf
 * @date:2020年7月6日
 */
public interface ICouManager {	     
	     public BeanCouInfo add(double coupMoney,int collRequest,Date StartTime,Date finishTime) throws BaseException;
	     public void delet(BeanCouInfo cou) throws BaseException;
	     public List<BeanCouInfo> loadAll() throws BaseException;
	     public void changeCoup(BeanCouInfo coup) throws BaseException;
}
