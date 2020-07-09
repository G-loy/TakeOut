package cn.edu.zucc.take_out.itf;

import java.util.List;

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
}
