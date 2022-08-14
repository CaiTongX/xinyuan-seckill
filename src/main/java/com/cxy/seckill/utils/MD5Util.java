package com.cxy.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * 
 * @author 53429 MD5工具类
 *
 */
@Component // 标注一个类为spring容器的bean
public class MD5Util {
	/*
	 * 实现MD5加密
	 */
	public static String md5(String src) {
		return DigestUtils.md5Hex(src);
	}

	/*
	 * 准备盐
	 */
	private static final String salt = "1a2b3c4d";

	/*
	 * 混淆前端传入的密码(第一次md5加密)
	 */
	public static String inputPassToFromPass(String inputPass) {
		String str =""+ salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5)+salt.charAt(4);
		return md5(str);// 加密完成,传入混淆后的前端传入的密码
	}

	/*
	 * 混淆后端存入数据库中的密码(第二次md5加密)
	 */
	public static String formPassToDBPass(String formPass, String salt) {
		String str = ""+ salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5)+salt.charAt(4);
		return md5(str);// 加密完成
	}

	/*
	 * 最终要调用的加密操作
	 */
	public static String inputPassToDBPass(String inputPass, String salt) {
		String formPass = inputPassToFromPass(inputPass);
		String dbPass = formPassToDBPass(formPass, salt);
		return dbPass;
	}
	/*
	 * 测试
	 */
	public static void main(String[] args) {
		System.out.println(inputPassToFromPass("123456"));
		System.out.println(formPassToDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9", "1a2b3c4d"));//二次加密的密码
		System.out.println(inputPassToDBPass("123456", "1a2b3c4d"));//最后存储到数据库中的密码和第二个密码一致
	}
}
