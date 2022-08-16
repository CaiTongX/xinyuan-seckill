package com.cxy.seckill.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.thymeleaf.util.StringUtils;

import com.cxy.seckill.pojo.User;
import com.cxy.seckill.service.IUserService;
import com.cxy.seckill.utils.CookieUtil;

/**
 * 
 * @author 53429
 *自定义用户参数
 */
@Component//要在别的类注入此类
public class UserArgumentResolver implements HandlerMethodArgumentResolver{
	@Autowired
	private IUserService iUserService;
	/*
	 * 做条件的判断 只有符合才会执行下面第二个方法
	 * @see org.springframework.web.method.support.HandlerMethodArgumentResolver#supportsParameter(org.springframework.core.MethodParameter)
	 */
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		//判断是否为user类
		Class<?> clazz=parameter.getParameterType();
		return clazz==User.class;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		//通过webRequest获取到前端的request
		HttpServletRequest request=webRequest.getNativeRequest(HttpServletRequest.class);
		//通过webRequest获取到前端的response
		HttpServletResponse response=webRequest.getNativeResponse(HttpServletResponse.class);
		//通过前端的request获取到cookie
		String ticket=CookieUtil.getCookieValue(request, "userTicket");
		//做一下非空验证
		if(StringUtils.isEmpty(ticket)) {
			return null;
		}
		return iUserService.getUserByCookie(ticket, request, response);
	}

}
