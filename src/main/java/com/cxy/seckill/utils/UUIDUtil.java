package com.cxy.seckill.utils;

import java.util.UUID;

/**
 * 
 * @author 53429
 *专门生成cookie的工具类
 */
public class UUIDUtil {
	public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
