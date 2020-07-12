package cn.edu.zucc.take_out.itf;
/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.itf
 * @date:2020年7月9日
 */

import java.util.List;

import cn.edu.zucc.take_out.model.BeanMjPlan;
import cn.edu.zucc.take_out.util.BaseException;

public interface IMJPlanManager {
       public BeanMjPlan addPlan(String shopName,Double mjMoney,Double discantMoney,boolean canADD)throws BaseException;
       public List<BeanMjPlan> loadAll()throws BaseException;
       public void deletPlan(BeanMjPlan mjPlan) throws BaseException;
       public void changePlan(BeanMjPlan plan) throws BaseException;
       public double getMJMoney(double totalMoney,int shop_id)throws BaseException;
       public int getMJId(double totalMoney,int shop_id) throws BaseException;
       
}
