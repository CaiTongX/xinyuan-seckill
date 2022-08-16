package com.cxy.seckill.exception;
/**
 * 
 * @author 53429
 *全局异常
 */

import com.cxy.seckill.vo.RespBeanEnum;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor//空参构造
public class GlobalException extends RuntimeException{//该类需要继承RuntimeException
	
	//返回枚举
	private RespBeanEnum respBeanEnum;
	

    public GlobalException(RespBeanEnum respBeanEnum) {
        this.respBeanEnum = respBeanEnum;
    }

}
