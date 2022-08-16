package com.cxy.seckill.serivce.impl;

import com.cxy.seckill.pojo.Order;
import com.cxy.seckill.mapper.OrderMapper;
import com.cxy.seckill.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxy
 * @since 2022-08-16
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
