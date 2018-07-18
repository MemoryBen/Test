package com.lingnan.edu.usermgr.controller;

import java.util.Vector;

import com.lingnan.edu.usermgr.business.service.UserService;
import com.lingnan.edu.usermgr.business.service.UserServiceImpl;
import com.lingnan.edu.usermgr.domain.UserVO;

public class UserController {

	UserService userService = UserServiceImpl.getInstance();
	
	public UserVO doLogin(String name, String password) {
		UserVO uv = null;
		try {
			uv = userService.login(name, password);
		} catch (Exception e) {
			System.out.println("登陆错误"+e.getMessage());
		}		
		return uv;
	}
	
	public boolean doRegister(String _userid, String _name, String _pass, String _mail, String _birth) {
		boolean flag = false;
		flag = userService.register(_userid, _name, _pass, _mail, _birth);
		return flag;
	}
	public boolean addUser(UserVO uv) {
		boolean flag = false;
		flag = userService.addUser(uv);
		return flag;
	}
	public boolean deleteUserById(String _id) {
		boolean flag = false;
		flag = userService.deleteUserById(_id);
		return flag;
	}
	public Vector<UserVO> findAllUser(){
		Vector<UserVO> vu = new Vector<UserVO>();
		vu = userService.findAllUser();
		return vu;
	}
	public UserVO findUserById(String _id) {
		UserVO uv = new UserVO();
		uv = userService.findUserById(_id);
		return uv;
	}
	public boolean updateUserById(UserVO uv) {
		boolean flag = false;
		flag = userService.updateUserById(uv);
		return flag;
	}
}
