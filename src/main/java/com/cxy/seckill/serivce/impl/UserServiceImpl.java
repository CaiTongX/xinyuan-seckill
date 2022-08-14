package com.cxy.seckill.serivce.impl;

import com.cxy.seckill.pojo.User;
import com.cxy.seckill.mapper.UserMapper;
import com.cxy.seckill.service.IUserService;
import com.cxy.seckill.utils.MD5Util;
import com.cxy.seckill.utils.ValidatorUtil;
import com.cxy.seckill.vo.LoginVo;
import com.cxy.seckill.vo.RespBean;
import com.cxy.seckill.vo.RespBeanEnum;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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

	// 登录功能的实现
	@Override
	public RespBean doLogin(LoginVo loginVo) {
		// TODO Auto-generated method stub
		String mobile = loginVo.getMobile();// 从前端取到手机号的值
		String password = loginVo.getPassword();

		// 有了自定义注解就不需要一下的参数校验

		/*
		 * if(StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)) { return
		 * RespBean.error(RespBeanEnum.LOGIN_ERROR);//枚举显示登录错误 }
		 * if(!ValidatorUtil.isMobile(mobile)) { return
		 * RespBean.error(RespBeanEnum.MOBILE_ERROR); }
		 */

		// 根据手机号获取用户
		User user = userMapper.selectById(mobile);
		if (user == null) {
			return RespBean.error(RespBeanEnum.LOGIN_ERROR);
		}
		// 判断密码是否正确
		if (!MD5Util.formPassToDBPass(password, user.getSlat()).equals(user.getPssword())) {
			return RespBean.error(RespBeanEnum.LOGIN_ERROR);
		}
		return RespBean.success();
	}

}
