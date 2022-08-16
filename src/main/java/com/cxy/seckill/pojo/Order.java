package com.cxy.seckill.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author cxy
 * @since 2022-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userId;

    private String goodsId;

    private String deliveryAddrId;

    private String goodsName;

    private String goodsCount;

    private String goodsPrice;

    private String orderChannel;

    private String status;

    private Date createDate;

    private Date payDate;


}
