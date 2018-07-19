package com.lingnan.edu.common.dao;

import java.sql.Connection;

import com.lingnan.edu.common.exception.ServiceException;
import com.lingnan.edu.usermgr.business.dao.UserDaoImpl;

/**
 * 使用了工厂模式方法，能通过用户给的字段确定所需要实现的实例
 * @author 98242
 *
 */
public class DaoFactory {
	/**
	 * 通过连接和类型返回相应的DAO接口
	 * @param conn
	 * @param type
	 * @return 返回BaseDao这个统一接口
	 */
	public static BaseDao getDao(Connection conn, String type) {
		if("user".equals(type)) {
			return new UserDaoImpl(conn);
		}
		else {
			throw new ServiceException("DAO工厂方法出错");
		}
	}
	
}
