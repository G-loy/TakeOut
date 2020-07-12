package cn.edu.zucc.take_out.control;

import java.sql.Date;

import cn.edu.zucc.take_out.model.BeanProductOrder;
import cn.edu.zucc.take_out.util.BaseException;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.control
 * @date:2020年7月11日
 */
public interface IProductEvaluateManager {
      public void evaluate(BeanProductOrder productOrder,String details,int star)throws BaseException;
}
