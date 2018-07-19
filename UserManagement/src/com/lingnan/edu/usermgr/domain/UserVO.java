package com.lingnan.edu.usermgr.domain;

/**
 * 等同于DTO，表的数据的集合
 * @author 98242
 *
 */
public class UserVO {
	/**
	 * 用户编号
	 */
	private int id;
	/**
	 * 用户账号
	 */
	private String userid;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String pass;
	/**
	 * 邮箱
	 */
	private String mail;
	/**
	 * 权限
	 */
	private String power;
	/**
	 * 生日
	 */
	private String birth;
	/**
	 * 状态
	 */
	private String status;
	
	/**
	 * 各自的Get/Set方法
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
