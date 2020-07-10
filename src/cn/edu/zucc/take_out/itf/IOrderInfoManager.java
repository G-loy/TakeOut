package cn.edu.zucc.take_out.itf;

import cn.edu.zucc.take_out.model.BeanOrderInfo;
import cn.edu.zucc.take_out.model.BeanProductInfo;
import cn.edu.zucc.take_out.util.BaseException;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.itf
 * @date:2020年7月9日
 */
public interface IOrderInfoManager {
       public BeanOrderInfo add(BeanProductInfo product,int number,boolean isCoup)throws BaseException;
       public void delet(BeanOrderInfo order)throws BaseException;
}
