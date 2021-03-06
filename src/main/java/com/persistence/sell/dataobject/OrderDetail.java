package com.persistence.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    /*单价*/
    private BigDecimal productPrice;

    /*商品数量*/
    private Integer productQuantity;

    /*商品小图*/
    private String productIcon;

    private Date createTime;

    private Date updateTime;

}
