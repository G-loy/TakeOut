package cn.edu.zucc.take_out.itf;
/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.itf
 * @date:2020年7月10日
 */

import java.sql.Date;

import cn.edu.zucc.take_out.model.BeanAddress;
import cn.edu.zucc.take_out.model.BeanProductInfo;
import cn.edu.zucc.take_out.model.BeanProductOrder;
import cn.edu.zucc.take_out.model.BeanRiderInfo;
import cn.edu.zucc.take_out.model.BeanUserHasCouInfo;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;

public interface IProductOrderManager {
	public BeanProductOrder add(BeanProductInfo product,BeanUserInfo user,BeanRiderInfo rider,BeanUserHasCouInfo userHasCouInfo,Date time,BeanAddress address,String state) throws BaseException;
}
