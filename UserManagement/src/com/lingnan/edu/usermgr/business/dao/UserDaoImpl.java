package com.lingnan.edu.usermgr.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.lingnan.edu.common.util.DBCUtil;
import com.lingnan.edu.common.util.TypeUtil;
import com.lingnan.edu.usermgr.domain.UserVO;

/**
 * 用户DAO中方法的实现
 * @author 98242
 *
 */
public class UserDaoImpl implements UserDao{
	
	/**
	 * 私有连接实现单例模式
	 */
	private Connection conn = null;
	
	/**
	 * 构造方法私有
	 * @param conn
	 */
	public UserDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 登陆方法
	 */
	@Override
	public UserVO login(String name, String password) {
		ResultSet rs = null;
		Statement stmt = null;
		PreparedStatement prep = null;
		UserVO uv = new UserVO();
		try {
			
//			prep = conn.prepareStatement("select * from T_USER where USERID = ? and PASS = ?");
//			name = name.trim();
//			System.out.println(name);
//			prep.setString(1, name);
//			password = password.trim();
//			System.out.println(password);
//			prep.setString(2, password);			
//			rs = prep.executeQuery();
			
			stmt = conn.createStatement();			
			String sql = "select * from T_USER where userid = '"+name+"' and pass = '"+password+"' and status = '1' ";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				uv.setId(rs.getInt("id"));		
				uv.setBirth(rs.getString("birth"));
				uv.setMail(rs.getString("mail"));
				uv.setName(rs.getString("name"));
				uv.setPass(rs.getString("pass"));
				uv.setPower(rs.getString("power"));
				uv.setStatus(rs.getString("status"));
				uv.setUserid(rs.getString("userid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCUtil.closeStatement(rs, stmt);
			DBCUtil.closePreparedStatement(prep);
		}
		return uv;
	}

	/**
	 * 注册方法
	 */
	@Override
	public boolean register(String _userid, String _name, String _pass, String _mail, String _birth) {
		boolean flag = false;
		ResultSet rs = null;
		Statement stmt = null;
		PreparedStatement prep = null;
		System.out.println(_birth);
//		java.sql.Date birth = new java.sql.Date(TypeUtil.strToDate(_birth).getTime());
//		System.out.println(birth);
		try {
			stmt = conn.createStatement();
//			String sql = "insert into T_USER(userid,name,pass,mail,power,birth,status) values('"+_userid+"','"+_name+"','"+_pass+"','"+_mail+"','普通用户','"+birth+"','1')";
//			String sql = "insert into T_USER(userid,name,pass,mail,power,birth,status) values('"+_userid+"','"+_name+"','"+_pass+"','"+_mail+"','普通用户',"+"to_date('"+_birth+"','yyyy-mm-dd')"+",'1')";
			
			prep = conn.prepareStatement("insert into T_USER(userid,name,pass,mail,power,birth,status) values(?, ?, ?, ?, ?, ?, ?)");
			prep.setString(1, _userid);
			prep.setString(2, _name);
			prep.setString(3, _pass);
			prep.setString(4, _mail);
			prep.setString(5, "普通用户");
			prep.setDate(6, new java.sql.Date(TypeUtil.strToDate(_birth).getTime()));
			prep.setString(7, "1");
			int i = prep.executeUpdate();
//			int i = stmt.executeUpdate(sql);
			if(i>0)
				flag = true;
			else
				flag = false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCUtil.closeStatement(rs, stmt);
			DBCUtil.closePreparedStatement(prep);
		}	
		return flag;
	}

	/**
	 * 添加用户
	 */
	@Override
	public boolean addUser(UserVO uv) {
		boolean flag = false;
		ResultSet rs = null;
		PreparedStatement prep = null;
		try {			
			prep = conn.prepareStatement("insert into T_USER(userid,name,pass,mail,power,birth,status) values(?, ?, ?, ?, ?, ?, ?)");
			prep.setString(1, uv.getUserid());
			prep.setString(2, uv.getName());
			prep.setString(3, uv.getPass());
			prep.setString(4, uv.getMail());
			prep.setString(5, uv.getPower());
			prep.setDate(6, new java.sql.Date(TypeUtil.strToDate(uv.getBirth()).getTime()));
			prep.setString(7, "1");
			int i = prep.executeUpdate();
			if(i>0)
				flag = true;
			else
				flag = false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCUtil.closeStatement(rs, null);
			DBCUtil.closePreparedStatement(prep);
		} 
		return flag;
	}

	/**
	 * 根据ID删除用户
	 */
	@Override
	public boolean deleteUserById(String _id) {
		boolean flag = false;
		ResultSet rs = null;
		PreparedStatement prep = null;
		try {			
			prep = conn.prepareStatement("delete from t_user where id = "+_id);
			prep.setInt(5, Integer.parseInt(_id));
			int i = prep.executeUpdate();
			if(i>0)
				flag = true;
			else
				flag = false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCUtil.closeStatement(rs, null);
			DBCUtil.closePreparedStatement(prep);
		} 
		return flag;
	}

	/**
	 * 查找全部用户
	 */
	@Override
	public Vector<UserVO> findAllUser() {
		ResultSet rs = null;
		Statement stmt = null;
		Vector<UserVO> vu = new Vector<UserVO>();
		try {
			stmt = conn.createStatement();			
			String sql = "select * from T_USER";
			rs = stmt.executeQuery(sql);
			int row = 0;	
			while(rs.next()) {
				UserVO uv2 = new UserVO();
				uv2.setId(rs.getInt("id"));		
				uv2.setBirth(rs.getString("birth"));
				uv2.setMail(rs.getString("mail"));
				uv2.setName(rs.getString("name"));
				uv2.setPass(rs.getString("pass"));
				uv2.setPower(rs.getString("power"));
				uv2.setStatus(rs.getString("status"));
				uv2.setUserid(rs.getString("userid"));
				row++;
				vu.add(uv2);
			}
			System.out.println(row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCUtil.closeStatement(rs, stmt);
		}
		return vu;
	}

	/**
	 * 根据ID查找用户
	 */
	@Override
	public UserVO findUserById(String _id) {
		ResultSet rs = null;
		Statement stmt = null;
		UserVO uv = new UserVO();
		try {
			stmt = conn.createStatement();			
			String sql = "select * from T_USER where id = '"+_id+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				uv.setId(rs.getInt("id"));		
				uv.setBirth(rs.getString("birth"));
				uv.setMail(rs.getString("mail"));
				uv.setName(rs.getString("name"));
				uv.setPass(rs.getString("pass"));
				uv.setPower(rs.getString("power"));
				uv.setStatus(rs.getString("status"));
				uv.setUserid(rs.getString("userid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCUtil.closeStatement(rs, stmt);
		}
		return uv;
	}

	/**
	 * 根据ID更新用户
	 */
	@Override
	public boolean updateUserById(UserVO uv) {
		boolean flag = false;
		ResultSet rs = null;
		PreparedStatement prep = null;
		try {			
			prep = conn.prepareStatement("update T_USER set userid = ? ,name = ?,pass = ?,mail = ?,power = ?,birth = ?,status = ? where id = "+uv.getId());
			prep.setString(1, uv.getUserid());
			prep.setString(2, uv.getName());
			prep.setString(3, uv.getPass());
			prep.setString(4, uv.getMail());
			prep.setString(5, uv.getPower());
			prep.setDate(6, new java.sql.Date(TypeUtil.strToDate(uv.getBirth()).getTime()));
			prep.setString(7, uv.getStatus());
			int i = prep.executeUpdate();
			if(i>0)
				flag = true;
			else
				flag = false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCUtil.closeStatement(rs, null);
		} 
		return flag;
	}

	/**
	 * 根据姓名查找用户
	 */
	@Override
	public Vector<UserVO> findUserByName(String _name) {
		ResultSet rs = null;
		Statement stmt = null;
		PreparedStatement prep = null;
		Vector<UserVO> vu = new Vector<UserVO>();
		try {
			prep = conn.prepareStatement("select * from T_USER where NAME = ?");
			prep.setString(1, _name);
			rs = prep.executeQuery();
//			stmt = conn.createStatement();			
//			String sql = "select * from T_USER where name = '"+_name+"'";
//			rs = stmt.executeQuery(sql);
			UserVO uv = new UserVO();
			while(rs.next()) {
				uv.setId(rs.getInt("id"));		
				uv.setBirth(rs.getString("birth"));
				uv.setMail(rs.getString("mail"));
				uv.setName(rs.getString("name"));
				uv.setPass(rs.getString("pass"));
				uv.setPower(rs.getString("power"));
				uv.setStatus(rs.getString("status"));
				uv.setUserid(rs.getString("userid"));
				vu.add(uv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCUtil.closeStatement(rs, stmt);
		}
		return vu;
	}
	
}
