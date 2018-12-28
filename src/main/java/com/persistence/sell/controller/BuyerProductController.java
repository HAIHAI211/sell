package com.persistence.sell.controller;

import com.persistence.sell.vo.ProductInfoVo;
import com.persistence.sell.vo.ProductVo;
import com.persistence.sell.vo.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @GetMapping("/list")
    public ResultVo list() {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");

        ProductVo productVo = new ProductVo();
        ProductInfoVo productInfoVo = new ProductInfoVo();
        productVo.setProductInfoVoList(Arrays.asList(productInfoVo));


        resultVo.setData(Arrays.asList(productVo));
        return resultVo;
    }
}
