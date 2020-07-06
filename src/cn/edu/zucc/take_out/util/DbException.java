package cn.edu.zucc.take_out.util;

public class DbException extends BaseException {
	public DbException(java.lang.Throwable ex){
		super("���ݿ��������"+ex.getMessage());
	}
}
