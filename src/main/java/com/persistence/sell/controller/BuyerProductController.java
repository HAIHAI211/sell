package com.persistence.sell.controller;

import com.persistence.sell.dataobject.ProductCategory;
import com.persistence.sell.dataobject.ProductInfo;
import com.persistence.sell.service.ProductCategoryService;
import com.persistence.sell.service.ProductInfoService;
import com.persistence.sell.utils.ResultVoUtils;
import com.persistence.sell.vo.ProductInfoVo;
import com.persistence.sell.vo.ProductVo;
import com.persistence.sell.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVo list() {

        // 1、查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        // 2、查询类目（一次性查询）

        // 传统方法
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo: productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        // 精简方法(java8, lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        // 3、数据拼装
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductVo productVo = new ProductVo();
            BeanUtils.copyProperties(productCategory, productVo);
            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }
        return ResultVoUtils.success(productVoList);
    }
}
