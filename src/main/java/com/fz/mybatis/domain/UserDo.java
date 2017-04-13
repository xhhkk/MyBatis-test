package com.fz.mybatis.domain;

import com.fz.mybatis.BaseDo;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2017/4/12.
 */
@Data
public class UserDo extends BaseDo {
    private String userName;//��½�û���
    private String password;//��½����
    private String realName;//��ʵ����
    private String email;//�����ʼ�
    private String cellphone;//��ϵ�绰
    private String address;//��ַ
    private String userType;//user_type = 1:ϵͳ�û� 0:ע���Ա�û�

    private UserCustomDo userCustomDo;

    private List<String> idds;
}
