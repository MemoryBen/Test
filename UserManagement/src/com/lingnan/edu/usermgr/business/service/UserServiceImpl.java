package com.lingnan.edu.usermgr.business.service;

import java.sql.Connection;
import java.util.List;
import java.util.Vector;

import com.lingnan.edu.common.constant.EnumType;
import com.lingnan.edu.common.dao.DaoFactory;
import com.lingnan.edu.common.exception.DAOException;
import com.lingnan.edu.common.exception.ServiceException;
import com.lingnan.edu.common.util.DBCUtil;
import com.lingnan.edu.usermgr.business.dao.UserDao;
import com.lingnan.edu.usermgr.domain.UserVO;

/**
 * 用户服务接口的方法的实现
 * @author 98242
 *
 */
public class UserServiceImpl implements UserService{

	/**
	 * 私有实例提供统一访问接口
	 */
	private static UserService userService = new UserServiceImpl();
	
	/**
	 * 私有构造方法
	 */
	private UserServiceImpl() {
		
	}
	
	/**
	 * 获取访问接口
	 * @return
	 */
	public static UserService getInstance() {
		return userService;
	}
	
	/**
	 * 登陆方法
	 */
	@Override
	public UserVO login(String name, String password) {
		Connection conn = null;
		UserVO uv = null;
		try {
			conn = DBCUtil.getConnection();
			UserDao ua = (UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			uv = ua.login(name, password);
		} catch (DAOException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException("登陆错误");
		} finally {
			DBCUtil.closeConnection(conn);
		}
		return uv;	
	}

	/**
	 * 注册方法
	 */
	@Override
	public boolean register(String _userid, String _name, String _pass, String _mail, String _birth) {
		Connection conn = null;
		boolean flag = false;
		try {
			conn = DBCUtil.getConnection();
			UserDao ua = (UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			flag = ua.register(_userid, _name, _pass, _mail, _birth);
		} catch (DAOException e) {
			throw e;
		} finally {
			DBCUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * 增加用户
	 */
	@Override
	public boolean addUser(UserVO uv) {
		Connection conn = null;
		boolean flag = false;
		try {
			conn = DBCUtil.getConnection();
			UserDao ua = (UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			flag = ua.addUser(uv);
		} catch (DAOException e) {
			throw e;
		} finally {
			DBCUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * 根据ID删除用户
	 */
	@Override
	public boolean deleteUserById(String _id) {
		Connection conn = null;
		boolean flag = false;
		try {
			conn = DBCUtil.getConnection();
			UserDao ua = (UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			flag = ua.deleteUserById(_id);
		} catch (DAOException e) {
			throw e;
		} finally {
			DBCUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * 查找全部用户
	 */
	@Override
	public Vector<UserVO> findAllUser() {
		Connection conn = null;
		Vector<UserVO> vu = new Vector<UserVO>();
		try {
			conn = DBCUtil.getConnection();
			UserDao ua = (UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			vu = ua.findAllUser();
		} catch (DAOException e) {
			throw e;
		} finally {
			DBCUtil.closeConnection(conn);
		}
		return vu;
	}

	/**
	 * 根据ID查找用户
	 */
	@Override
	public UserVO findUserById(String _id) {
		Connection conn = null;
		UserVO uv = new UserVO();
		try {
			conn = DBCUtil.getConnection();
			UserDao ua = (UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			uv = ua.findUserById(_id);
		} catch (DAOException e) {
			throw e;
		} finally {
			DBCUtil.closeConnection(conn);
		}
		return uv;
	}

	/**
	 * 根据ID更新用户信息
	 */
	@Override
	public boolean updateUserById(UserVO uv) {
		Connection conn = null;
		boolean flag = false;
		try {
			conn = DBCUtil.getConnection();
			UserDao ua = (UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			flag = ua.updateUserById(uv);
		} catch (DAOException e) {
			throw e;
		} finally {
			DBCUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * 根据姓名查找用户
	 */
	@Override
	public Vector<UserVO> findUserByName(String _name) {
		Connection conn = null;
		Vector<UserVO> vu = new Vector<UserVO>();
		try {
			conn = DBCUtil.getConnection();
			UserDao ua = (UserDao) DaoFactory.getDao(conn, EnumType.USER_DAO);
			vu = ua.findUserByName(_name);
		} catch (DAOException e) {
			throw e;
		} finally {
			DBCUtil.closeConnection(conn);
		}
		return vu;
	}
	
	
}
