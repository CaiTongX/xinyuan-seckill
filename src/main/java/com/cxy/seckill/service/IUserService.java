package com.cxy.seckill.service;

import com.cxy.seckill.pojo.User;
import com.cxy.seckill.vo.LoginVo;
import com.cxy.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cxy
 * @since 2022-08-13
 */
public interface IUserService extends IService<User> {
	/*
	 * 登录接口
	 */
	RespBean doLogin(LoginVo loginVo, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);
	
	/*
	 * 根据cookie获取用户
	 */
	User getUserByCookie(String userTicket,HttpServletRequest request,HttpServletResponse response);
}
