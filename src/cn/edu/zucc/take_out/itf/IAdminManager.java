package cn.edu.zucc.take_out.itf;

import java.util.List;

import cn.edu.zucc.take_out.model.BeanAdminInfo;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.itf
 * @date:2020年7月4日
 */
public interface IAdminManager {
    public BeanAdminInfo login(String name,String pwd) throws BaseException;
    public BeanAdminInfo add(String name,String pwd1,String pwd2)throws BaseException;
    public List<BeanAdminInfo> loadAll()throws BaseException;
    public void deleteAdmin(BeanAdminInfo adim) throws BaseException;
    public void changePwd(BeanAdminInfo admin,String oldPwd,String newPwd1,String newPwd2)throws BaseException;
}
