package com.lingnan.edu.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库连接工具类
 * @author 98242
 *
 */
public class DBCUtil {
	
	/**
	 * 获取连接
	 * @return 返回连接
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String user = "scott";
			String password = "123456";
			conn = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 开始
	 * @param conn
	 */
	public static void beginTransaction(Connection conn) {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 提交
	 * @param conn
	 */
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 回滚
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭连接
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		try {
			if(conn != null) {
				conn.close();	
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	/**
	 * 关闭rs,stmt
	 * @param rs
	 * @param stmt
	 */
	public static void closeStatement(ResultSet rs, Statement stmt) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭PreparedStatement
	 * @param prep
	 */
	public static void closePreparedStatement(PreparedStatement prep) {
		try {
			if(prep != null) {
				prep.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
