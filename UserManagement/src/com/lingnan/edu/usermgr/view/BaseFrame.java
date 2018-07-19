package com.lingnan.edu.usermgr.view;

import com.lingnan.edu.usermgr.domain.UserVO;

/**
 * 页面接口
 * @author 98242
 *
 */
public interface BaseFrame {

	/**
	 * 主页面
	 */
	public void show();
	
	/**
	 * 添加页面
	 * @param type
	 */
	public void addshow(String type);
	
	/**
	 * 查找页面
	 */
	public void searchshow();
	
	
	/**
	 * 更新页面
	 * @param type
	 * @param uv
	 */
	public void updateshow(String type, UserVO uv);
	
}
