package com.persistence.sell.repository;

import com.persistence.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
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
    @Transactional // 在测试中此注解会完全回滚 ，在service中如果报错此注解会回滚
    public void saveTest() {
//        Optional<ProductCategory> productCategoryOptional = repository.findById(2);
//        ProductCategory productCategory = productCategoryOptional.get();
//        productCategory.setCategoryType(3);
//        repository.save(productCategory);


        ProductCategory productCategory = new ProductCategory("女生最爱", 2);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }


}