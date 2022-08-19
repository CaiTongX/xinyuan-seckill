package com.cxy.seckill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxy.seckill.pojo.Order;
import com.cxy.seckill.pojo.SeckillOrder;
import com.cxy.seckill.pojo.User;
import com.cxy.seckill.service.IGoodsService;
import com.cxy.seckill.service.IOrderService;
import com.cxy.seckill.service.ISeckillOrderService;
import com.cxy.seckill.vo.GoodsVo;
import com.cxy.seckill.vo.RespBeanEnum;

/**
 * 
 * @author 53429 秒 杀
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {

	@Autowired
	private IGoodsService iGoodsService;
	@Autowired
	private ISeckillOrderService iSeckillOrderService;
	@Autowired
    private IOrderService orderService;

	/*
	 * 秒杀功能
	 * 优化前QPS194 商品超卖
	 */
	@RequestMapping("/doSeckill")
	public String doSeckill(Model model, User user, String goodsId) {
		if (user == null) {
			return "login";// 如果找不到对象就返回登录页面
		}
		model.addAttribute("user", user);// 把用户传往前端页面
		GoodsVo goods = iGoodsService.findGoodsVoByGoodsId(goodsId);
		// 从数据库中的数据中判断是否有库存
		if (goods.getStockCount() < 1) {
			model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
			return "secKillFail";
		}
		// 判断是否重复抢购 mybatis-plus的写法
		SeckillOrder seckillOrder = iSeckillOrderService
				.getOne(new QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId));
		if(seckillOrder!=null) {
			model.addAttribute("errmsg", RespBeanEnum.REPEATE_ERROR.getMessage());
			return "secKillFail";//返回失败页面
		}
		//下订单
		Order order=orderService.seckill(user,goods);
		model.addAttribute("order", order);//传订单
		model.addAttribute("goods", goods);//传商品
		return "orderDetail";
		
		
	}

}
