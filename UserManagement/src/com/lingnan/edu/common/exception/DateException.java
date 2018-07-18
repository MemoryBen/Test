package com.lingnan.edu.common.exception;

/**
 * Date异常类
 * @author 98242
 *
 */
public class DateException extends RuntimeException {
	
	/**
	 * 默认构造方法
	 */
	public DateException(){
		
	}
	
	/**
	 * 构造方法
	 * @param arg0 产生异常原因
	 */
	public DateException(Throwable arg0){
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * @param arg1 异常详细原因
	 */
	public DateException(String arg1){
		super(arg1);
	}

	/**
	 * 构造方法
	 * @param arg1 异常详细原因
	 * @param arg0 产生异常原因
	 */
	public DateException(String arg1, Throwable arg0){
		super(arg1, arg0);
	}
	
}
