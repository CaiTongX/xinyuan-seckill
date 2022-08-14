package com.cxy.seckill.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxy.seckill.service.IUserService;
import com.cxy.seckill.vo.LoginVo;
import com.cxy.seckill.vo.RespBean;

import lombok.extern.slf4j.Slf4j;





/**
 * 
 * @author 53429
 * 登录
 *
 */
@Controller//页面跳转不能用RestController,只能用Controller
@RequestMapping("/login")
@Slf4j//用来输出日志,不知道好不好用
public class LoginController {
	@Autowired
	private IUserService userService;
	/*
	 * 跳转到登录界面的方法
	 */
	
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";//跳转页面
	}
	/*
	 * 登录功能
	 */
	@RequestMapping("/doLogin")
	@ResponseBody
	public RespBean doLogin(@Valid LoginVo loginVo) {//注解用来校验
		
		return userService.doLogin(loginVo);
	}
}
