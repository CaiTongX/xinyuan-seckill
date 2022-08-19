package com.cxy.seckill.serivce.impl;

import com.cxy.seckill.pojo.User;
import com.cxy.seckill.exception.GlobalException;
import com.cxy.seckill.mapper.UserMapper;
import com.cxy.seckill.service.IUserService;
import com.cxy.seckill.utils.CookieUtil;
import com.cxy.seckill.utils.MD5Util;
import com.cxy.seckill.utils.UUIDUtil;
import com.cxy.seckill.vo.LoginVo;
import com.cxy.seckill.vo.RespBean;
import com.cxy.seckill.vo.RespBeanEnum;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cxy
 * @since 2022-08-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RedisTemplate redisTemplate;

	// 登录功能的实现
	@Override
	public RespBean doLogin(LoginVo loginVo, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		// TODO Auto-generated method stub
		String mobile = loginVo.getMobile();// 从前端取到手机号的值
		String password = loginVo.getPassword();

		// 有了自定义注解就不需要以下的参数校验

		/*
		 * if(StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)) { return
		 * RespBean.error(RespBeanEnum.LOGIN_ERROR);//枚举显示登录错误 }
		 * if(!ValidatorUtil.isMobile(mobile)) { return
		 * RespBean.error(RespBeanEnum.MOBILE_ERROR); }
		 */

		// 根据手机号获取用户
		User user = userMapper.selectById(mobile);
		if (user == null) {
			//自己定义过后可以直接抛异常
			throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
		}
		// 判断密码是否正确
		if (!MD5Util.formPassToDBPass(password, user.getSlat()).equals(user.getPssword())) {
			throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
		}
		//生成cookie
		String ticket = UUIDUtil.uuid();
		//将用户信息存入cookie中
		redisTemplate.opsForValue().set("user :"+ticket, user);
		//之前把用户信息放到session里面 但想要的做法是直接存入redis内
		//httpServletRequest.getSession().setAttribute(ticket, user);//key是cookie value是user对象
		CookieUtil.setCookie(httpServletRequest, httpServletResponse, "userTicket",ticket);
		return RespBean.success(ticket);
	}
	
	/*
	 * 根据cookie获取用户对象
	 * @see com.cxy.seckill.service.IUserService#getUserByCookie(java.lang.String)
	 */

	@Override
	public User getUserByCookie(String userTicket,HttpServletRequest request,HttpServletResponse response) {
		//后台检查
		if(StringUtils.isEmpty(userTicket)) {
			return null;
		}
		// TODO Auto-generated method stub
		User user=(User)redisTemplate.opsForValue().get("user :"+userTicket);
		//优化
		if(user !=null) {
			CookieUtil.setCookie(request, response, "userTicket", userTicket);
		}
		return user;
	}

}
