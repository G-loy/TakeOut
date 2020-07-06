package cn.edu.zucc.take_out.itf;

import java.util.List;

import cn.edu.zucc.take_out.model.BeanShopInfo;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.itf
 * @date:2020年7月5日
 */
public interface IShopManager {
     public BeanShopInfo regist(String shopName,int star)throws BaseException;
     public void delete(BeanShopInfo shop)throws BaseException;
     public List<BeanShopInfo> loadAll() throws BaseException;
}
