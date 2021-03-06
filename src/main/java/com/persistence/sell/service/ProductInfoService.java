package com.persistence.sell.service;

import com.persistence.sell.dataobject.ProductInfo;
import com.persistence.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductInfoService {
    Optional<ProductInfo> findOne(String productId);

    /*
    * 查询所有在架商品列表
    * */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // todo 加库存
    void increaseStock(List<CartDTO> cartDTOList);

    // todo 减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
