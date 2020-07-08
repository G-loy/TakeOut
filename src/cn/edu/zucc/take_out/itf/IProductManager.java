package cn.edu.zucc.take_out.itf;

import java.util.List;

import cn.edu.zucc.take_out.model.BeanProductClass;
import cn.edu.zucc.take_out.model.BeanProductInfo;
import cn.edu.zucc.take_out.util.BaseException;


/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.itf
 * @date:2020年7月6日
 */
public interface IProductManager {
	public BeanProductInfo add(String className,String product_name,Double price,Double prefPrice,Integer number)throws BaseException;
	public void delet(BeanProductInfo product)throws BaseException;
	public List<BeanProductInfo> loadAll(BeanProductClass productClass) throws BaseException;

}
