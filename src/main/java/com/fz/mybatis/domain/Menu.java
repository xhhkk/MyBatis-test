package com.fz.mybatis.domain;

import com.fz.mybatis.common.BaseDo;
import lombok.Data;

/**
 * 菜单模型类
 *
 */
@Data
public class Menu extends BaseDo {

    private String menuName;
    private Integer pId;
    private String menuUri;
    private String menuStyle;
    private String isMenu;
}
