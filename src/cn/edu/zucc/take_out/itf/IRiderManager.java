package cn.edu.zucc.take_out.itf;

import java.util.List;

import cn.edu.zucc.take_out.model.BeanRiderInfo;
import cn.edu.zucc.take_out.util.BaseException;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.itf
 * @date:2020年7月5日
 */
public interface IRiderManager {
    public BeanRiderInfo regist(String name,int star) throws BaseException;
    public void delete(BeanRiderInfo rider)throws BaseException;
    public List<BeanRiderInfo> loadAll() throws BaseException;
}
