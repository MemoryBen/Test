package com.lingnan.edu.usermgr.business.service;

import java.util.Vector;

import com.lingnan.edu.usermgr.domain.UserVO;

/**
 * 用户的服务接口
 * @author 98242
 *
 */
public interface UserService {
	
	public UserVO login(String name, String password);
	public boolean register(String _userid, String _name, String _pass, String _mail, String _birth);
	public boolean addUser(UserVO uv);
	public boolean deleteUserById(String _id);
	public Vector<UserVO> findAllUser();
	public UserVO findUserById(String _id);
	public boolean updateUserById(UserVO uv);

}