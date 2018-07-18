package com.lingnan.edu.common.exception;

/**
 * service异常类
 * @author 98242
 *
 */

public class ServiceException extends RuntimeException {
	
	/**
	 * 默认构造方法
	 */
	public ServiceException(){
		
	}
	
	/**
	 * 构造方法
	 * @param arg0 产生异常原因
	 */
	public ServiceException(Throwable arg0){
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * @param arg1 异常详细原因
	 */
	public ServiceException(String arg1){
		super(arg1);
	}

	/**
	 * 构造方法
	 * @param arg1 异常详细原因
	 * @param arg0 产生异常原因
	 */
	public ServiceException(String arg1, Throwable arg0){
		super(arg1, arg0);
	}
	
}
