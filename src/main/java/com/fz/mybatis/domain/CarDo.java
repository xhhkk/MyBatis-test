package com.fz.mybatis.domain;

import com.fz.mybatis.BaseDo;
import lombok.Data;

/**
 * 购物车模型类
 * Created by zhangls on 2016/11/3 0003.
 */
@Data
public class CarDo extends BaseDo {

    private Integer userId;
    private Integer prodId;
    private String proSize;
    private String proColor;
    private Integer proNum;
    private Double proPrice;
    private Double talPrice;

    private ProductDo pro;

}
