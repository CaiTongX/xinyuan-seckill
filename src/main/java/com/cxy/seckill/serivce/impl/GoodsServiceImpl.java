package com.cxy.seckill.serivce.impl;

import com.cxy.seckill.pojo.Goods;
import com.cxy.seckill.mapper.GoodsMapper;
import com.cxy.seckill.service.IGoodsService;
import com.cxy.seckill.vo.GoodsVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
	
	//从数据库查询商品列表 注入mapper层
	@Autowired
	private GoodsMapper goodsMapper;
	/*
	 * 获取商品列表
	 * @see com.cxy.seckill.service.IGoodsService#findGoodsVo()
	 */
	@Override
	public List<GoodsVo> findGoodsVo() {
		// TODO Auto-generated method stub
		return goodsMapper.findGoodsVo();
	}
	/*
	 * 获取商品详情
	 * @see com.cxy.seckill.service.IGoodsService#findGoodsVoByGoodsId(java.lang.String)
	 */
	@Override
	public GoodsVo findGoodsVoByGoodsId(String goodsId) {
		// TODO Auto-generated method stub
		return goodsMapper.findGoodsVoByGoodsId(goodsId);
	}

}
