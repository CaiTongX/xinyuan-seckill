package com.cxy.seckill.vo;

import java.util.Date;

import com.cxy.seckill.pojo.Goods;

/**
 * 
 * @author 53429
 *商品返回对象
 */
public class GoodsVo extends Goods{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	/**
	 * 
	 */
	private String seckillPrice;

    private String stockCount;

    private Date startDate;

    private Date endDate;

	public String getSeckillPrice() {
		return seckillPrice;
	}

	public void setSeckillPrice(String seckillPrice) {
		this.seckillPrice = seckillPrice;
	}

	public String getStockCount() {
		return stockCount;
	}

	public void setStockCount(String stockCount) {
		this.stockCount = stockCount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public GoodsVo(String seckillPrice, String stockCount, Date startDate, Date endDate) {
		super();
		this.seckillPrice = seckillPrice;
		this.stockCount = stockCount;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public GoodsVo() {
		super();
	}
	
}
