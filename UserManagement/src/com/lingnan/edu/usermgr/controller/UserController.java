package com.lingnan.edu.usermgr.controller;

import java.sql.Connection;
import java.util.List;
import java.util.Vector;

import com.lingnan.edu.common.constant.EnumType;
import com.lingnan.edu.common.dao.DaoFactory;
import com.lingnan.edu.common.exception.DAOException;
import com.lingnan.edu.common.util.DBCUtil;
import com.lingnan.edu.usermgr.business.dao.UserDao;
import com.lingnan.edu.usermgr.business.service.UserService;
import com.lingnan.edu.usermgr.business.service.UserServiceImpl;
import com.lingnan.edu.usermgr.domain.UserVO;

public class UserController {

	/**
	 * 获取User的接口
	 */
	UserService userService = UserServiceImpl.getInstance();
	
	/**
	 * 登陆方法的调用
	 * @param name 账号
	 * @param password 密码
	 * @return
	 */
	public UserVO doLogin(String name, String password) {
		UserVO uv = null;
		try {
			uv = userService.login(name, password);
		} catch (Exception e) {
			System.out.println("登陆错误"+e.getMessage());
		}		
		return uv;
	}
	
	/**
	 * 调用注册方法
	 * @param _userid 账号
	 * @param _name 姓名
	 * @param _pass 密码
	 * @param _mail 邮箱
	 * @param _birth 生日
	 * @return
	 */
	public boolean doRegister(String _userid, String _name, String _pass, String _mail, String _birth) {
		boolean flag = false;
		flag = userService.register(_userid, _name, _pass, _mail, _birth);
		return flag;
	}
	
	/**
	 * 添加用户方法的调用
	 * @param uv 用户信息
	 * @return 是否成功
	 */
	public boolean addUser(UserVO uv) {
		boolean flag = false;
		flag = userService.addUser(uv);
		System.out.println("添加用户成功");
		return flag;
	}
	
	/**
	 * 根据ID删除用户
	 * @param _id 用户ID
	 * @return 是否删除成功
	 */
	public boolean deleteUserById(String _id) {
		boolean flag = false;
		flag = userService.deleteUserById(_id);
		return flag;
	}
	
	/**
	 * 查找全部用户
	 * @return 用户信息集合
	 */
	public Vector<UserVO> findAllUser(){
		Vector<UserVO> vu = new Vector<UserVO>();
		vu = userService.findAllUser();
		return vu;
	}
	
	/**
	 * 根据ID查找用户
	 * @param _id 用户ID
	 * @return 用户信息
	 */
	public UserVO findUserById(String _id) {
		UserVO uv = new UserVO();
		uv = userService.findUserById(_id);
		return uv;
	}
	
	/**
	 * 根据姓名查找用户
	 * @param _name 姓名
	 * @return 用户信息集合
	 */
	public Vector<UserVO> findUserByName(String _name) {
		Vector<UserVO> vu = new Vector<UserVO>();
		vu = userService.findUserByName(_name);
		return vu;
	}
	
	/**
	 * 根据ID更新用户信息
	 * @param uv 新用户信息
	 * @return 是否更新成功
	 */
	public boolean updateUserById(UserVO uv) {
		boolean flag = false;
		flag = userService.updateUserById(uv);
		System.out.println("更新成功");
		return flag;
	}
	
	/**
	 * 分页查询
	 * @param pageNo 页码
	 * @param pageSize 大小
	 * @return
	 */
	public Vector<UserVO> findUsers(int pageNo, int pageSize) {
		Vector<UserVO> vu = new Vector<UserVO>();
		return vu = userService.findUsers(pageNo, pageSize);
	}
}
