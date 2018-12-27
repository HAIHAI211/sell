package com.persistence.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@DynamicUpdate // 想要自动更新updateTime和createTime
// 动态更新指的是数据变化了才会更新，没有变化的不会更新
@Data
@Table(name="product_category")
public class ProductCategory {
    /*类目id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    /*类目名字*/
    private String categoryName;
    /*类目编号*/
    private Integer categoryType;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {
    }

    /*创建时间*/
//    private Date createTime;
//
//    private Date updateTime;
}
