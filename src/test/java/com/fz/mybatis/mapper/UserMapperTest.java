package com.fz.mybatis.mapper;

import com.fz.mybatis.domain.User;
import com.fz.mybatis.domain.UserDo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by Administrator on 2016-12-03.
 */
@Slf4j
public class UserMapperTest {

    SqlSessionFactory sqlSessionFactory;
    SqlSession session;

    @Before
    public void setUp() throws Exception {
        //mybatis配置文件
        String resource = "mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        session = sqlSessionFactory.openSession();
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    /**
     * 测试一级缓存
     * @throws Exception
     */
    @Test
    public void testFindUserById() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);

        UserDo user = mapper.findUserById(1);

        log.info("User：{}",user);

       /* User u = new User();
        u.setId(12);
        u.setUserName("wangwu");
        u.setPassword("pppppppppppppppp");
        u.setAddress("中文");
        u.setUpdateBy("admin");

        mapper.updateById(u);*/

        UserDo user2 = mapper.findUserById(1);

        log.info("User2：{}",user2);

    }

    @Test
    public void testCache() throws Exception {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);//创建代理对象
        //下边查询使用一个SqlSession
        //第一次发起请求，查询id为1的用户
        UserDo user1 = userMapper1.findUserById(1);
        System.out.println(user1.getUserName());
        //不关闭SqlSession无法写进二级缓存区域中
        sqlSession1.close();

        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);//创建代理对象
        //第二次发起请求，查询id为1的用户
        UserDo user2 = userMapper2.findUserById(1);
        System.out.println(user2.getUserName());
        sqlSession2.close();
    }
}