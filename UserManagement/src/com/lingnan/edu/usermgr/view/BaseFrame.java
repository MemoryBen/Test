package com.lingnan.edu.usermgr.view;

import com.lingnan.edu.usermgr.domain.UserVO;

public interface BaseFrame {

	public void show();
	
	public void addshow(String type);
	
	public void searchshow();
	
	public void updateshow(String type, UserVO uv);
	
}
