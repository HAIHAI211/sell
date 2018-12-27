package com.persistence.sell.service.impl;

import com.persistence.sell.dataobject.ProductCategory;
import com.persistence.sell.repository.ProductCategoryRepository;
import com.persistence.sell.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        Optional<ProductCategory> productCategoryOptional = repository.findById(categoryId);
        if (productCategoryOptional.isPresent()) {
            return productCategoryOptional.get();
        }
        log.info("根据id查询productCategory为空,{}", productCategoryOptional);
        return null;
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
