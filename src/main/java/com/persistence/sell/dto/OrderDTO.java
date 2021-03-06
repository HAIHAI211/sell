package com.persistence.sell.dto;

import com.persistence.sell.dataobject.OrderDetail;
import com.persistence.sell.enums.OrderStatusEnum;
import com.persistence.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    /*订单id*/
    private String orderId;

    /*买家名字*/
    private String buyerName;

    /*买家手机号*/
    private String buyerPhone;

    /*买家地址*/
    private String buyerAddress;

    /*买家微信openid*/
    private String buyerOpenid;

    /*订单总金额*/
    private BigDecimal orderAmount;

    /*订单状态, 默认0为新下单*/
    private Integer orderStatus;

    /*支付状态, 默认0为未支付*/
    private Integer payStatus;

    /*创建时间*/
    // private Date createTime;

    /*更新时间*/
    // private Date updateTime;

    /*订单明细*/
    List<OrderDetail> orderDetailList;
}
