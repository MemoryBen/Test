package com.lingnan.edu.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lingnan.edu.common.util.MailUtil;
import com.lingnan.edu.common.util.TypeUtil;
import com.lingnan.edu.usermgr.controller.UserController;
import com.lingnan.edu.usermgr.domain.UserVO;

/**
 * 主页面
 * @author 98242
 *
 */
public class IndexFrame implements BaseFrame{

	/**
	 * 显示
	 */
	@Override
	public void show() {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		int i = -1;
		while(i!=3) {
			while(i!=3) {
				System.out.println("欢迎使用用户管理系统");
				System.out.println("========================");
				System.out.println("1、登陆");
				System.out.println("2、注册");
				System.out.println("3、退出");
				System.out.println("========================");
				try {
					i = Integer.parseInt(buff.readLine());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				switch(i) {
					case 1:{
						try {
							this.loginshow();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					case 2:{
						try {
							this.register();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					case 3:{
						System.out.println("欢迎使用!");
						System.exit(0);
					}
					default:
						System.out.println("请输入正确编号");
				}
			}		
		}			
	}
	
	/**
	 * 登陆页面
	 * @throws IOException
	 */
	public void loginshow() throws IOException {
		BufferedReader buff1 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入登陆账号");
		String name = buff1.readLine();
		System.out.println("请输入登陆密码");
		String password = buff1.readLine();
		UserController uc = new UserController();
		UserVO uv = uc.doLogin(name, password);
		String power = uv.getPower();
		if(power.equals("普通用户")) {
			NomalFrame nf = new NomalFrame(uv);
			nf.nshow();
		}
		else if(power.equals("管理员")) {
			AdminFrame af = new AdminFrame(uv);
			af.ashow();
		}
	}
	
	/**
	 * 注册页面
	 * @throws IOException
	 */
	public void register() throws IOException {
		String mail = null;
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入账号");
		String userid = buff.readLine();
		System.out.println("请输入姓名");
		String name = buff.readLine();
		System.out.println("请输入密码");
		String pass = buff.readLine();
		while(true) {
			System.out.println("请输入邮箱");
			mail = buff.readLine();
			if(!MailUtil.judge(mail)) {
				System.out.println("邮箱格式错误");
			}
			else
				break;
		}	
		System.out.println("请输入生日");
		String birth = buff.readLine();
		UserController uc = new UserController();		
		boolean flag = uc.doRegister(userid, name, pass, mail, birth);
		if(flag) {
			System.out.println("注册成功");
		}
		else {
			System.out.println("注册失败");
		}
	}
	
	@Override
	public void addshow(String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchshow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateshow(String type, UserVO uv) {
		// TODO Auto-generated method stub
		
	}

}
