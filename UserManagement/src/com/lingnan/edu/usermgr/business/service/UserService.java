package com.lingnan.edu.usermgr.business.service;

import java.util.List;
import java.util.Vector;

import com.lingnan.edu.usermgr.domain.UserVO;

/**
 * 用户的服务接口
 * @author 98242
 *
 */
public interface UserService {
	
	/**
	 * 登陆
	 * @param name 账号
	 * @param password 密码
	 * @return 用户信息
	 */
	public UserVO login(String name, String password);
	
	/**
	 * 注册
	 * @param _userid 账号
	 * @param _name 姓名
	 * @param _pass 密码
	 * @param _mail 邮箱
	 * @param _birth 生日
	 * @return 是否成功
	 */
	public boolean register(String _userid, String _name, String _pass, String _mail, String _birth);
	
	/**
	 * 添加用户
	 * @param uv 用户资料
	 * @return
	 */
	public boolean addUser(UserVO uv);
	
	/**
	 * 根据编号删除用户
	 * @param _id 用户编号
	 * @return 是否成功
	 */
	public boolean deleteUserById(String _id);
	
	/**
	 * 查找全部用户
	 * @return 用户信息集合
	 */
	public Vector<UserVO> findAllUser();
	
	/**
	 * 分页查询
	 * @return 用户信息集合
	 */
	public Vector<UserVO> findUsers(int pageNo, int pageSize);
	
	/**
	 * 根据编号查找用户
	 * @param _id 用户编号
	 * @return 用户信息
	 */
	public UserVO findUserById(String _id);
	
	/**
	 * 根据姓名查找用户
	 * @param _name 姓名
	 * @return 用户信息集合
	 */
	public Vector<UserVO> findUserByName(String _name);
	
	/**
	 * 更新用户信息
	 * @param uv 用户信息
	 * @return 是否成功
	 */
	public boolean updateUserById(UserVO uv);

}
