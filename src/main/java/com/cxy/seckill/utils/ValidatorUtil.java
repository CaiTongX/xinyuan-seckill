package com.cxy.seckill.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.thymeleaf.util.StringUtils;

/**
 * 
 * @author 53429
 *手机号码格式校验
 */
public class ValidatorUtil {
	private static final Pattern mobile_patten = Pattern.compile("[1]([3-9])[0-9]{9}$");
	
	public static boolean isMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return false;
        }
        Matcher matcher = mobile_patten.matcher(mobile);
        return matcher.matches();
    }
}
