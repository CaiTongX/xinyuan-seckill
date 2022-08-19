package com.cxy.seckill.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxy.seckill.pojo.User;
import com.cxy.seckill.service.IGoodsService;
import com.cxy.seckill.service.IUserService;
import com.cxy.seckill.vo.GoodsVo;

/**
 * 
 * @author 53429 商品页面的控制类
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private IUserService iUserService;
	// 需要查询商品所以注入商品的服务接口
	@Autowired
	private IGoodsService iGoodsService;

	/*
	 * window优化前qps200左右非常可怜
	 * 跳转到商品列表页面
	 */
	// HttpSession用来获取用户信息
	// Model用来在页面上显示信息
	// ticket表示cookie的值
	// CookieValue用来取到cookie的值
	@RequestMapping("/toList")
	public String toList(Model model, User user) {
		// 每个页面都需要验证,过于臃肿
		// if(StringUtils.isEmpty(ticket)) {
		// return "login";
		// }

		// 通过缓存取到user对象,现在要直接通过cookie
		// User user=(User)session.getAttribute(ticket);
		// 到这一步实现通过redis存储用户信息
		// User user=iUserService.getUserByCookie(ticket, request, response);
		// if(user==null) {
		// return "login";
		// }
		model.addAttribute("user", user);// 将对象发送到前端
		model.addAttribute("goodsList", iGoodsService.findGoodsVo());
		return "goodsList";
	}

	/*
	 * 跳转商品详情页
	 */
	@RequestMapping("/toDetail/{goodsId}")
	public String toDetail(Model model, User user, @PathVariable String goodsId) {
		model.addAttribute("user", user);
		GoodsVo goodsVo = iGoodsService.findGoodsVoByGoodsId(goodsId);
		Date startDate = goodsVo.getStartDate();
		Date endDate = goodsVo.getEndDate();
		Date nowDate = new Date();
		// 秒杀状态
		int seckillStatus = 0;
		//秒杀倒计时
        int remainSeconds = 0;

		if (nowDate.before(startDate)) {
			// 秒杀还未开始0
			remainSeconds = (int) ((startDate.getTime() - nowDate.getTime()) / 1000);
		} else if (nowDate.after(endDate)) {
			// 秒杀已经结束
			seckillStatus = 2;
			remainSeconds = -1;

		} else {
			// 秒杀进行中
			seckillStatus = 1;
			remainSeconds = 0;
		}
		model.addAttribute("remainSeconds", remainSeconds);
		model.addAttribute("goods", goodsVo);
		model.addAttribute("seckillStatus", seckillStatus);
		return "goodsDetail";
	}
}
