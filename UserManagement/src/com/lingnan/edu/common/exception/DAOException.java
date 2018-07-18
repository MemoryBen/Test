package com.lingnan.edu.common.exception;

/**
 * DAO异常类
 * @author 98242
 *
 */

public class DAOException extends RuntimeException{
	
	/**
	 * 默认构造方法
	 */
	public DAOException(){
		
	}
	
	/**
	 * 构造方法
	 * @param arg0 产生异常原因
	 */
	public DAOException(Throwable arg0){
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * @param arg1 异常详细原因
	 */
	public DAOException(String arg1){
		super(arg1);
	}

	/**
	 * 构造方法
	 * @param arg1 异常详细原因
	 * @param arg0 产生异常原因
	 */
	public DAOException(String arg1, Throwable arg0){
		super(arg1, arg0);
	}
	
}
