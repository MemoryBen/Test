package com.lingnan.edu.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lingnan.edu.usermgr.domain.UserVO;

public class AdminFrame extends NomalFrame{

	public AdminFrame(UserVO uv) {
		super(uv);
	}
	
	public void ashow() {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("欢迎 "+uv.getName()+" 用户使用本系统");
		System.out.println("你的权限为："+uv.getPower());
		int i =-1;
		while(true) {
			System.out.println("=================");
			System.out.println("1、添加用户");
			System.out.println("2、删除用户");
			System.out.println("3、查找用户");
			System.out.println("4、修改用户");
			System.out.println("================");
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
						break;
					}
					case 2:{
						break;
					}
					case 3:{
						break;
					}
					case 4:{
						break;
					}
				}
			}
		}
	}
}
