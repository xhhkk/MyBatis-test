package com.fz.mybatis.domain;

import com.fz.mybatis.BaseDo;
import lombok.Data;

/**
 * Created by zhangls on 2016/11/16 0016.
 */
@Data
public class User extends BaseDo {

    private String userName;
    private String password;
    private String realName;
    private String email;
    private String address;
    private String cellPhone;
    private String userType;
}
