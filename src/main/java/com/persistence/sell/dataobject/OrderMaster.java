package com.persistence.sell.dataobject;

import com.persistence.sell.enums.OrderStatusEnum;
import com.persistence.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /*支付状态, 默认0为未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
}
