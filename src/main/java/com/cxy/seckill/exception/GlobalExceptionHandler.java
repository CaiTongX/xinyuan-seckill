package com.cxy.seckill.exception;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cxy.seckill.vo.RespBean;
import com.cxy.seckill.vo.RespBeanEnum;

/**
 * 
 * @author 53429 全局异常处理类
 */
@RestControllerAdvice // 返回Responsebody
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class) // 引入异常类
	public RespBean ExceptionHandler(Exception e) {
		if (e instanceof GlobalException) {// 如果传入异常在全局异常内
			GlobalException ex = (GlobalException) e;// 把此异常转为全局异常
			return RespBean.error(ex.getRespBeanEnum());
		} else if (e instanceof BindException) {// 如果抛出的是绑定异常 注意不要导错包是validation
			BindException bindException = (BindException) e;
			RespBean respBean = RespBean.error(RespBeanEnum.BIND_ERROR);
			// 获取异常内的第一个错误的默认信息
			respBean.setMessage("参数校验异常：" + bindException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
			return respBean;
		}
		// 如果不经过判断就正常抛
		System.out.println("异常信息" + e);
		return RespBean.error(RespBeanEnum.ERROR);
	}

}
