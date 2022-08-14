package com.cxy.seckill.service;

import com.cxy.seckill.pojo.User;
import com.cxy.seckill.vo.LoginVo;
import com.cxy.seckill.vo.RespBean;
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
	RespBean doLogin(LoginVo loginVo);

}
