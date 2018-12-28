package com.persistence.sell.utils;

import com.persistence.sell.dataobject.ProductCategory;
import com.persistence.sell.dataobject.ProductInfo;
import com.persistence.sell.vo.ProductInfoVo;
import com.persistence.sell.vo.ProductVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import static org.junit.Assert.*;

public class CopyUtilsTest {

    @Test
    public void getNullPropertyNames() {
    }

    @Test
    public void copyPropertiesIgnoreNull() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryName("饿了么");

        ProductVo productVo = new ProductVo();
        productVo.setCategoryName("美团");
        productVo.setCategoryType(66);

        CopyUtils.copyPropertiesIgnoreNull(productCategory, productVo);
//        BeanUtils.copyProperties(productCategory, productVo);
        Assert.assertEquals(new Integer(66), productVo.getCategoryType());

    }
}