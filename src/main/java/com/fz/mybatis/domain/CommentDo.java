package com.fz.mybatis.domain;


import lombok.Data;

/**
 * 评论模型类
 * Created by zhangls on 2016/11/3 0003.
 */
@Data
public class CommentDo extends BaseDo {

    private Integer proId;
    private Integer userId;
    private String comTitle;
    private String comDesc;
    private Double proScore;

    private String userName;
}
