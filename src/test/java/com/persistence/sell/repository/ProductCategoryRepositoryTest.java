package com.persistence.sell.repository;

import com.persistence.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        Optional<ProductCategory> productCategoryOptional = repository.findById(1);
        System.out.println(productCategoryOptional.get().toString());
        // Assert.assertTrue(productCategoryOptional.isPresent());
    }

    @Test
    public void saveTest() {
        Optional<ProductCategory> productCategoryOptional = repository.findById(2);
        ProductCategory productCategory = productCategoryOptional.get();
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }


}