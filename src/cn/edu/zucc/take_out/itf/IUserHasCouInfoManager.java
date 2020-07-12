package cn.edu.zucc.take_out.itf;

import java.util.List;

import cn.edu.zucc.take_out.model.BeanProductInfo;
import cn.edu.zucc.take_out.model.BeanUserHasCouInfo;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.itf
 * @date:2020年7月9日
 */
public interface IUserHasCouInfoManager {
       public List<BeanUserHasCouInfo> loadAllbyUserId(BeanUserInfo user) throws BaseException;
       public void delet(BeanUserHasCouInfo ubhci) throws BaseException;
       public void add(BeanUserHasCouInfo ubhci) throws BaseException;
       public BeanUserHasCouInfo SelectIsCoup(BeanProductInfo product) throws BaseException;
       public List<StringBuffer> showMoneyById() throws BaseException;
       public double getCutMoneyByID(int id) throws BaseException;
       public int findCoupId (BeanProductInfo product) throws BaseException;
       public double getCutMoney(BeanProductInfo product)throws BaseException;
       public void used(int coupId)throws BaseException;
       }
