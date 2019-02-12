package com.persistence.sell.controller.catstory;

import com.persistence.sell.enums.catstory.ClassicTypeEnum;
import com.persistence.sell.utils.ResultVoUtils;
import com.persistence.sell.vo.ResultVo;
import com.persistence.sell.vo.catstory.ClassicVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/catstory")
public class CatStoryController {

    @GetMapping("/classic/latest")
    public ResultVo getClassicLatest(){
        ClassicVo classicVo = new ClassicVo();
        classicVo.setContent("人生不能像做菜，把所有的料准备好才下锅");
        classicVo.setFavNums(0);
        classicVo.setId(1);
        classicVo.setImage("https://img-1255752606.cos.ap-chengdu.myqcloud.com/cat-story/%E3%80%8A%E9%A5%AE%E9%A3%9F%E7%94%B7%E5%A5%B3%E3%80%8B%402x.png?q-sign-algorithm=sha1&q-ak=AKIDq21BHQRunYcBMDxGkl9RvYjhCxGgQmOu&q-sign-time=1549960838;1549962638&q-key-time=1549960838;1549962638&q-header-list=&q-url-param-list=&q-signature=559a5181a159ed496888a2a609301662f96472e6&x-cos-security-token=93f5d2d65a05caf170185c8befa6eba92db3601e10001");
        classicVo.setIndex(1);
        classicVo.setLikeStatus(false);
        classicVo.setPubdate(LocalDate.of(2018, 6, 22));
        classicVo.setTitle("李安<<饮食男女>>");
        classicVo.setType(ClassicTypeEnum.MOVIE.getCode());
        return ResultVoUtils.success(classicVo);
    }
}
