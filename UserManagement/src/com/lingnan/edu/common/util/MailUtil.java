package com.lingnan.edu.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 判断邮箱格式类
 * @author 98242
 *
 */
public class MailUtil {
	
	/**
	 * 判断邮箱格式
	 * @param string
	 * @return 邮箱格式是否正确
	 */
	public static boolean judge(String string) {
		if (string == null)
            return false;
        String regEx1 = "^([a-z0-9A-Z_-]+[-|\\.]?)+[a-z0-9A-Z_-]@([a-z0-9A-Z_-]+(-[a-z0-9A-Z_-]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(string);
        if (m.matches())
            return true;
        else
            return false;
	}
	
}
