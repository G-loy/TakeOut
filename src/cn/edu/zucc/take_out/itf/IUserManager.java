package cn.edu.zucc.take_out.itf;

import java.util.List;

import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.itf
 * @date:2020年7月4日
 */
public interface IUserManager {
     public BeanUserInfo login(String phoneNumber,String pwd)throws BaseException;
     public BeanUserInfo regist(String phoneNumber,String pwd1,String pwd2)throws BaseException;
     public BeanUserInfo regist(String name,String phoneNumber,String gender,Boolean ismember) throws BaseException;
     public void delete(BeanUserInfo user) throws BaseException;
     public List<BeanUserInfo> loadAll() throws BaseException;
     
     
}
