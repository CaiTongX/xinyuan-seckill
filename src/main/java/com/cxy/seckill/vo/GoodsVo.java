package com.cxy.seckill.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.cxy.seckill.pojo.Goods;

/**
 * 
 * @author 53429
 *商品返回对象
 */
public class GoodsVo extends Goods {
	

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
	private BigDecimal seckillPrice;//在这里使用此类型防止数据丢失

    private int stockCount;

    private Date startDate;

    private Date endDate;

	public BigDecimal getSeckillPrice() {
		return seckillPrice;
	}

	public void setSeckillPrice(BigDecimal seckillPrice) {
		this.seckillPrice = seckillPrice;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
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

	public GoodsVo(BigDecimal seckillPrice, int stockCount, Date startDate, Date endDate) {
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
