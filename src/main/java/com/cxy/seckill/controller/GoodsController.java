package com.cxy.seckill.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.cxy.seckill.pojo.User;
import com.cxy.seckill.service.IUserService;

/**
 * 
 * @author 53429
 *商品页面的控制类
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private IUserService iUserService;
	/*
	 * 跳转到商品列表页面
	 */
	//HttpSession用来获取用户信息
	//Model用来在页面上显示信息
	//ticket表示cookie的值
	//CookieValue用来取到cookie的值
	@RequestMapping("/toList")
	public String toList(Model model,User user) {
		//每个页面都需要验证,过于臃肿
		//if(StringUtils.isEmpty(ticket)) {
			//return "login";
		//}
		
		//通过缓存取到user对象,现在要直接通过cookie
		//User user=(User)session.getAttribute(ticket);
		//到这一步实现通过redis存储用户信息
		//User user=iUserService.getUserByCookie(ticket, request, response);
		//if(user==null) {
			//return "login";
		//}
		model.addAttribute("user", user);//将对象发送到前端
		return "goodsList";
	}
}
