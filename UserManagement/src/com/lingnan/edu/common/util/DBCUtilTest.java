package com.lingnan.edu.common.util;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.Test;

import com.lingnan.edu.usermgr.domain.UserVO;

/**
 * 数据库连接测试类
 * @author 98242
 *
 */
public class DBCUtilTest {

	/**
	 * 获取连接测试方法
	 */
	@Test
	public void testGetConnection() {
		Connection conn = null;
		conn = DBCUtil.getConnection();
		boolean flag = false;
		ResultSet rs = null;
		PreparedStatement prep = null;
		try {		
			prep = conn.prepareStatement("insert into T_USER(userid,name,pass,mail,power,birth,status) values(?, ?, ?, ?, ?, ?, ?)");
			prep.setString(1, "123a");
			prep.setString(2, "123a");
			prep.setString(3, "123a");
			prep.setString(4, "123a");
			prep.setString(5, "普通用户");
			Date birth = TypeUtil.strToDate("2011-01-01");
			prep.setDate(6, new java.sql.Date(birth.getTime()));
			System.out.println(new java.sql.Date(birth.getTime()));
			prep.setString(7, "1");
			int i = prep.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCUtil.closeStatement(rs, null);
		}	
	}
}
