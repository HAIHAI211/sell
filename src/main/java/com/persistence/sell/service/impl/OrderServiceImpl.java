package com.persistence.sell.service.impl;

import com.persistence.sell.dataobject.OrderDetail;
import com.persistence.sell.dataobject.ProductInfo;
import com.persistence.sell.dto.OrderDTO;
import com.persistence.sell.service.OrderService;
import com.persistence.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        // 1、查询商品(数量，价格)
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()){
           Optional<ProductInfo> productInfoOptional =  productInfoService.findOne(orderDetail.getProductId());
        }
        // 2、计算总价

        // 3、写入订单数据库(orderMaster)

        // 4、扣库存

        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
