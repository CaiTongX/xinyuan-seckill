package com.cxy.seckill.serivce.impl;

import com.cxy.seckill.pojo.Order;
import com.cxy.seckill.pojo.SeckillGoods;
import com.cxy.seckill.pojo.SeckillOrder;
import com.cxy.seckill.pojo.User;
import com.cxy.seckill.mapper.OrderMapper;
import com.cxy.seckill.service.IOrderService;
import com.cxy.seckill.service.ISeckillGoodsService;
import com.cxy.seckill.service.ISeckillOrderService;
import com.cxy.seckill.vo.GoodsVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cxy
 * @since 2022-08-16
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
	@Autowired
	private ISeckillGoodsService iSeckillGoodsService;
	 @Autowired
	 private OrderMapper orderMapper;
	 @Autowired
	 private ISeckillOrderService iSeckillOrderService;
	/*
	 * 秒杀
	 * 
	 * @see com.cxy.seckill.service.IOrderService#seckill(com.cxy.seckill.pojo.User,
	 * com.cxy.seckill.vo.GoodsVo)
	 */
	@Override
	public Order seckill(User user, GoodsVo goods) {
		// TODO Auto-generated method stub
		// 拿到秒杀商品
		SeckillGoods seckillGoods = iSeckillGoodsService
				.getOne(new QueryWrapper<SeckillGoods>().eq("goods_id", goods.getId()));
		//设置库存
		seckillGoods.setStockCount(seckillGoods.getStockCount()-1);
		//更新
		iSeckillGoodsService.updateById(seckillGoods);
		
		//生成订单
		
        Order order = new Order();
        order.setUserId(user.getId());
        order.setGoodsId(goods.getId());
        order.setDeliveryAddrId("");
        order.setGoodsName(goods.getGoodsName());
        order.setGoodsCount(1);
        order.setGoodsPrice(seckillGoods.getSeckillPrice());
        order.setOrderChannel("1");
        order.setStatus("0");
        order.setCreateDate(new Date());
        orderMapper.insert(order);
		//生成秒杀订单
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setUserId(user.getId());
        seckillOrder.setOrderId(order.getId());
        seckillOrder.setGoodsId(goods.getId());
        iSeckillOrderService.save(seckillOrder);
        return order;
	}

}
