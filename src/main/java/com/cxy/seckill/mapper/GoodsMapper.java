package com.cxy.seckill.mapper;

import com.cxy.seckill.pojo.Goods;
import com.cxy.seckill.vo.GoodsVo;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cxy
 * @since 2022-08-16
 */
public interface GoodsMapper extends BaseMapper<Goods> {
	/*
	 * 获取商品列表
	 */
	List<GoodsVo> findGoodsVo();
	/*
	 * 获取商品详情
	 */
	GoodsVo findGoodsVoByGoodsId(String goodsId);

}
