package com.lingnan.edu.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * 邮箱格式测试类
 * @author 98242
 *
 */
public class MailUtilTest {

	@Test
	public void main() throws IOException {
		BufferedReader buf;
		buf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = buf.readLine();
			boolean flag = MailUtil.judge(str);
			if(flag) {
				System.out.println("正确");
			}
			else
				System.out.println("错误");
		}		
	}

}
