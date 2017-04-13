package com.fz.mybatis.domain;

import com.fz.mybatis.BaseDo;
import lombok.Data;

/**
 * 订单详表模型类
 * Created by
 */
@Data
public class OrderDetDo extends BaseDo {

    private String orderId;
    private Integer proId;
    private String proName;
    private Integer proNum;
    private String proDesc;
    private String proSize;
    private String proColor;
    private Double proPrice;
    private Double talPrice;

    private ProductDo productDo;
}
