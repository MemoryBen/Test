package com.lingnan.edu.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Vector;

import com.lingnan.edu.common.util.MailUtil;
import com.lingnan.edu.usermgr.controller.UserController;
import com.lingnan.edu.usermgr.domain.UserVO;

/**
 * 管理人员页面
 * @author 98242
 *
 */
public class AdminFrame extends NomalFrame{

	/**
	 * 继承自普通人员页面的构造方法
	 * @param uv
	 */
	public AdminFrame(UserVO uv) {
		super(uv);
	}
	
	/**
	 * 管理人员操作页面
	 * @throws IOException
	 */
	public void ashow() throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		UserController uc = new UserController();
		System.out.println("欢迎 "+uv.getName()+" 用户使用本系统");
		System.out.println("你的权限为："+uv.getPower());
		int i =-1;
		while(i!=5) {
			while(i!=5) {
				System.out.println("=================");
				System.out.println("1、添加用户");
				System.out.println("2、删除用户");
				System.out.println("3、查找用户");
				System.out.println("4、修改用户");
				System.out.println("5、退出");
				System.out.println("================");
				try {
					i = Integer.parseInt(buff.readLine());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				switch(i) {
					case 1:{
						UserVO uv1 = new UserVO();
						System.out.println("请输入账号");
						String userid = buff.readLine();
						uv1.setUserid(userid);
						System.out.println("请输入姓名");
						String name = buff.readLine();
						uv1.setName(name);
						System.out.println("请输入密码");
						String pass = buff.readLine();
						uv1.setPass(pass);
						String mail;
						while(true) {
							System.out.println("请输入邮箱");
							mail = buff.readLine();
							uv1.setMail(mail);
							if(!MailUtil.judge(mail)) {
								System.out.println("邮箱格式错误");
							}
							else
								break;
						}
						System.out.println("请输入权限");
						String power = buff.readLine();
						uv1.setPower(power);
						System.out.println("请输入生日");
						String birth = buff.readLine();
						uv1.setBirth(birth);
						System.out.println("请输入状态");
						String status = buff.readLine();
						uv1.setStatus(status);
						uc.addUser(uv1);
						break;
					}
					case 2:{
						System.out.println("请输入删除账号ID");
						String id = buff.readLine();
						boolean flag = uc.deleteUserById(id);
						break;
					}
					case 3:{
						int t = -1;
						while(t!=4) {
							System.out.println("1、查询全部用户");
							System.out.println("2、根据ID查询用户");
							System.out.println("3、根据姓名查询用户");
							System.out.println("4、退出");
							System.out.println("5、分页查询");
							t = Integer.parseInt(buff.readLine());
							switch(t) {
							case 1:{
								Vector<UserVO> vu = new Vector<UserVO>();
								vu = uc.findAllUser();
								System.out.println("编号\t\t账号\t\t姓名\t\t密码\t\t邮箱\t\t权限\t\t生日\t\t状态");
								for(UserVO user : vu) {
									System.out.print(user.getId());
									if(Integer.toString(user.getId()).length()>=8) {
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getUserid());
									if(user.getUserid().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getName());
									if(user.getName().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getPass());
									if(user.getPass().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getMail());
									if(user.getMail().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getPower());
									if(user.getPower().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getBirth().substring(0, 9));
									if(user.getBirth().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getStatus());
									if(user.getStatus().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.println();
								}
								break;
							}
							case 2:{
								System.out.println("请输入查找用户ID");
								String id = buff.readLine();
								UserVO uesr = new UserVO();
								uesr = uc.findUserById(id);
								System.out.println("编号: "+uesr.getId());
								System.out.println("账号: "+uesr.getUserid());
								System.out.println("姓名: "+uesr.getName());
								System.out.println("密码: "+uesr.getPass());
								System.out.println("邮箱: "+uesr.getMail());
								System.out.println("权限: "+uesr.getPower());
								System.out.println("生日: "+uesr.getBirth());
								System.out.println("状态: "+uesr.getStatus());
								break;
							}
							case 3:{
								System.out.println("请输入查找用户姓名");
								String name = buff.readLine();
								Vector<UserVO> vu = new Vector<UserVO>();
								vu = uc.findUserByName(name);
								System.out.println("编号\t\t账号\t\t姓名\t\t密码\t\t邮箱\t\t权限\t\t生日\t\t状态");
								for(UserVO user : vu) {
									System.out.print(user.getId());
									if(Integer.toString(user.getId()).length()>=8) {
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getUserid());
									if(user.getUserid().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getName());
									if(user.getName().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getPass());
									if(user.getPass().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getMail());
									if(user.getMail().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getPower());
									if(user.getPower().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getBirth().substring(0, 9));
									if(user.getBirth().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getStatus());
									if(user.getStatus().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.println();
								}
								break;
							}
							case 4:
								break;
							case 5:{
								Vector<UserVO> vu = new Vector<UserVO>();
								System.out.println("请输入页面大小");
								int pageSize = Integer.parseInt(buff.readLine());
								System.out.println("请输入页码");
								int pageNo = Integer.parseInt(buff.readLine()); 
								vu = uc.findUsers(pageNo, pageSize);								
								System.out.println("编号\t\t账号\t\t姓名\t\t密码\t\t邮箱\t\t权限\t\t生日\t\t状态");
								for(UserVO user : vu) {
									System.out.print(user.getId());
									if(Integer.toString(user.getId()).length()>=8) {
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getUserid());
									if(user.getUserid().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getName());
									if(user.getName().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getPass());
									if(user.getPass().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getMail());
									if(user.getMail().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getPower());
									if(user.getPower().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getBirth().substring(0, 9));
									if(user.getBirth().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.print(user.getStatus());
									if(user.getStatus().length()>=8){
										System.out.print("\t");
									}else {
										System.out.print("\t\t");
									}
									System.out.println();
								}
							}
							default:
								System.out.println("请输入正确编号");
							}
							
						}
						
						break;
					}
					case 4:{
						UserVO uv1 = new UserVO();
						System.out.println("请输入修改编号");
						String id = buff.readLine();
						uv1.setId(Integer.parseInt(id));
						System.out.println("请输入修改账号");
						String userid = buff.readLine();
						uv1.setUserid(userid);
						System.out.println("请输入修改姓名");
						String name = buff.readLine();
						uv1.setName(name);
						System.out.println("请输入修改密码");
						String pass = buff.readLine();
						uv1.setPass(pass);
						System.out.println("请输入修改邮箱");
						String mail = buff.readLine();
						uv1.setMail(mail);
						System.out.println("请输入修改生日");
						String birth = buff.readLine();
						uv1.setBirth(birth);
						System.out.println("请输入修改状态");
						String status = buff.readLine();
						uv1.setStatus(status);
						boolean flag = uc.updateUserById(uv1);
						if(flag) {
							System.out.println("更新成功");
						} else {
							System.out.println("更新失败");
						}
						break;
					}
					case 5:
						break;
					default:
						System.out.println("请输入正确编号");
				}
			}
		}
	}
}
