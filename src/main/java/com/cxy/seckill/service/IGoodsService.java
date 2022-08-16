package com.cxy.seckill.service;

import com.cxy.seckill.pojo.Goods;
import com.cxy.seckill.vo.GoodsVo;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cxy
 * @since 2022-08-16
 */
public interface IGoodsService extends IService<Goods> {
	/*
	 * 获取商品列表
	 */
	List<GoodsVo> findGoodsVo();
	/*
	 * 获取商品详情
	 */
	GoodsVo findGoodsVoByGoodsId(String goodsId);

}
