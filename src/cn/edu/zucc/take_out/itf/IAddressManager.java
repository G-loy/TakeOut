package cn.edu.zucc.take_out.itf;

import java.util.List;

import cn.edu.zucc.take_out.model.BeanAddress;
import cn.edu.zucc.take_out.util.BaseException;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.itf
 * @date:2020年7月8日
 */
public interface IAddressManager {
      public BeanAddress addAddress(int userId,String province,String city,String distance,String address,String linkman,String phonenumber) throws BaseException;
      public void deletAddress(BeanAddress address) throws BaseException;
      public List<BeanAddress> loadAll() throws BaseException;
      public List<StringBuffer> loadAddress()throws BaseException;
}
