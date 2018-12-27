package com.persistence.sell.service;

import com.persistence.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {
    ProductInfo findOne(String productId);

    /*
    * 查询所有在架商品列表
    * */
    List<ProductInfo> findUpAll();

    List<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // todo 加库存

    // todo 减库存
}
