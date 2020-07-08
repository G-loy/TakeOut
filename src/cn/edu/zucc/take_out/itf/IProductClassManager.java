package cn.edu.zucc.take_out.itf;

import java.util.List;

import cn.edu.zucc.take_out.model.BeanProductClass;
import cn.edu.zucc.take_out.util.BaseException;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.itf
 * @date:2020年7月7日
 */
public interface IProductClassManager {
	public BeanProductClass add(String className)throws BaseException;
	public void delet(BeanProductClass producClass)throws BaseException;
	public List<BeanProductClass> loadAll() throws BaseException;
	public List<String> getAllClassName() throws BaseException;
}
