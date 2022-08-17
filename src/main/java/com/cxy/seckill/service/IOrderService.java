package com.cxy.seckill.service;

import com.cxy.seckill.pojo.Order;
import com.cxy.seckill.pojo.User;
import com.cxy.seckill.vo.GoodsVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cxy
 * @since 2022-08-16
 */
public interface IOrderService extends IService<Order> {

	Order seckill(User user, GoodsVo goods);

}
