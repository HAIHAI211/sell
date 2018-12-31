package com.persistence.sell.service.impl;

import com.persistence.sell.dataobject.OrderDetail;
import com.persistence.sell.dataobject.OrderMaster;
import com.persistence.sell.dataobject.ProductInfo;
import com.persistence.sell.dto.CartDTO;
import com.persistence.sell.dto.OrderDTO;
import com.persistence.sell.enums.ResultEnum;
import com.persistence.sell.exception.SellException;
import com.persistence.sell.repository.OrderDetailRepository;
import com.persistence.sell.repository.OrderMasterRepository;
import com.persistence.sell.service.OrderService;
import com.persistence.sell.service.ProductInfoService;
import com.persistence.sell.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtils.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        // 1、查询商品(数量，价格)
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()){
           Optional<ProductInfo> productInfoOptional =  productInfoService.findOne(orderDetail.getProductId());
           if (!productInfoOptional.isPresent()){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
           }
           ProductInfo productInfo = productInfoOptional.get();
            // 2、计算订单总价
            orderAmount = orderDetail.getProductPrice()
                   .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                   .add(orderAmount);
            // 订单详情入库
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtils.genUniqueKey());
            BeanUtils.copyProperties(productInfo, orderDetail);
        }
        // 3、写入订单数据库(orderMaster和orderDetail)
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMasterRepository.save(orderMaster);

        // 4、扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productInfoService.decreaseStock(cartDTOList);

        return orderDTO;
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
