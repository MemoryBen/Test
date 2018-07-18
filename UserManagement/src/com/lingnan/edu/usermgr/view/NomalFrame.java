package com.lingnan.edu.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lingnan.edu.usermgr.controller.UserController;
import com.lingnan.edu.usermgr.domain.UserVO;

public class NomalFrame extends IndexFrame{
	
	public UserVO uv;
	
	public NomalFrame(UserVO uv) {
		this.uv = uv;
	}
	
	public void nshow() throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		UserController uc = new UserController();
		System.out.println("欢迎 "+uv.getName()+" 用户使用本系统");
		System.out.println("你的权限为："+uv.getPower());
		int i =-1;
		while(true) {
			System.out.println("=================");
			System.out.println("1、查询个人信息");
			System.out.println("2、修改个人信息");
			System.out.println("=================");
			while(true) {
				try {
					i = Integer.parseInt(buff.readLine());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				switch(i) {
					case 1:{
						System.out.println("编号: "+uv.getId());
						System.out.println("账号: "+uv.getUserid());
						System.out.println("姓名: "+uv.getName());
						System.out.println("密码: "+uv.getPass());
						System.out.println("邮箱: "+uv.getMail());
						System.out.println("权限: "+uv.getPower());
						System.out.println("生日: "+uv.getBirth());
						System.out.println("状态: "+uv.getStatus());
						break;
					}
					case 2:{
						BufferedReader buff1 = new BufferedReader(new InputStreamReader(System.in));
						UserVO uv1 = new UserVO();
						uv1 = uv;
						System.out.println("请输入修改账号");
						String userid = buff1.readLine();
						uv1.setUserid(userid);
						System.out.println("请输入修改姓名");
						String name = buff1.readLine();
						uv1.setName(name);
						System.out.println("请输入修改密码");
						String pass = buff1.readLine();
						uv1.setPass(pass);
						System.out.println("请输入修改邮箱");
						String mail = buff1.readLine();
						uv1.setMail(mail);
						System.out.println("请输入修改生日");
						String birth = buff1.readLine();
						uv1.setBirth(birth);
						boolean flag = uc.updateUserById(uv1);
						if(flag) {
							System.out.println("更新成功");
						} else {
							System.out.println("更新失败");
						}						
						break;
					}
				}
			}
		}
	}

}
