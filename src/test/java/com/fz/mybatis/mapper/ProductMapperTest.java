package com.fz.mybatis.mapper;

import com.fz.mybatis.domain.ProductDo;
import com.fz.mybatis.domain.User;
import com.fz.mybatis.domain.UserDo;
import com.fz.mybatis.mapper.ProductMapper;
import com.fz.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-12-01.
 */
@Slf4j
public class ProductMapperTest {

    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    SqlSession session1;
    SqlSession session2;
    SqlSession session3;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        session1 = sqlSessionFactory.openSession();
        session2 = sqlSessionFactory.openSession();
        session3 = sqlSessionFactory.openSession();
    }

    @After
    public void tearDown() throws Exception {
        session.close();
//        session1.close();
//        session2.close();
//        session3.close();
    }


    @Test
    public void testFindByIdProd() throws Exception {
        ProductMapper mapper = session.getMapper(ProductMapper.class);
        ProductDo pro = mapper.findByIdProd(1);
        log.info("pro {}", pro);
    }

    @Test
    public void testInsertProd() throws Exception {

        ProductMapper mapper = session.getMapper(ProductMapper.class);

        ProductDo prod = new ProductDo();
        prod.setProName("淑女成衣真丝裙2");
        prod.setProRealPrice(562.5);
        prod.setProNowPrice(Double.valueOf("123.5"));
        prod.setIsStock("1");
        prod.setProColor("red,green");
        prod.setProSize("L,M,XL,XXL,XXXL");
        prod.setProDesc("活动促销中,活动促销中,活动促销中,活动促销中");
        prod.setProScore(4.5);
        prod.setProPicId(1);
        prod.setProPicUri("/super-shop/shop/assets/temp/products/model1.jpg");
        prod.setProTypeId("1");


//        values('淑女成衣真丝裙子，活动促销中','889.32','499.21','1','活动促销中,活动促销中,活动促销中,活动促销中,活动促销中',
//                'L,M,XL,XXL,XXXL','red,green','4.5','9','1','/super-shop/shop/assets/temp/products/model1.jpg','1','admin','2016-11-01 21:31:52','admin','2016-11-01 21:31:52');

        Integer i = mapper.insertProd(prod);

//        session.commit();

        log.info("i={}", i);


        log.info("prod.id={}", prod.getId());
    }

    @Test
    public void testUpdateBatchId() throws Exception {

        UserMapper mapper = session.getMapper(UserMapper.class);

        List<User> ls = new ArrayList<User>();
        User user = new User();
        user.setId(1);
        user.setAddress("洛阳");
        user.setCellPhone("13387654321");
        ls.add(user);

        User user1 = new User();
        user1.setId(2);
        user1.setAddress("杭州");
        user1.setCellPhone("15812345678");
        ls.add(user1);


        mapper.updateBatchId(ls);

        session.commit();
    }

    @Test
    public void testQueryBatchId() throws Exception {

        UserMapper mapper = session.getMapper(UserMapper.class);

        List<User> ls = new ArrayList<User>();
        User user = new User();
        user.setId(1);
        ls.add(user);

        User user1 = new User();
        user1.setId(2);
        ls.add(user1);

        List<User> userLs = mapper.queryBatchId(ls);

        log.info("i={}", userLs.size());

    }

    @Test
    public void testQueryBatchIds() throws Exception {

        UserMapper mapper = session.getMapper(UserMapper.class);

        UserDo user = new UserDo();
        List<String> ls = new ArrayList<String>();
        ls.add("1");
        ls.add("2");
        user.setIdds(ls);

        List<UserDo> userLs = mapper.queryBatchIds(user);

        log.info("i={}", userLs.size());
    }

    @Test
    public void testQueryProDetail() throws Exception {

        ProductMapper mapper = session.getMapper(ProductMapper.class);

        List<ProductDo> ls = mapper.queryProDetail();

        log.info("i={}", ls.size());
    }

    @Test
    public void testQueryProDetails() throws Exception {

        ProductMapper mapper1 = session1.getMapper(ProductMapper.class);
        ProductMapper mapper2 = session2.getMapper(ProductMapper.class);
        ProductMapper mapper3 = session3.getMapper(ProductMapper.class);
        ProductMapper mapper = session.getMapper(ProductMapper.class);

        long beginTime1 = System.nanoTime();
        List<ProductDo> ls1 = mapper1.queryProDetails();
        long endTime1 = System.nanoTime();
        log.info("11111查询时间 :{}", (endTime1 - beginTime1) + "ns");
        //关闭sqlsession时才写入二级缓存
        session1.close();

        long beginTime2 = System.nanoTime();
        List<ProductDo> ls2 = mapper2.queryProDetails();
        long endTime2 = System.nanoTime();
        log.info("22222查询时间 :{}", (endTime2 - beginTime2) + "ns");
        session2.close();

        long beginTime3 = System.nanoTime();
        List<ProductDo> ls3 = mapper3.queryProDetails();
        long endTime3 = System.nanoTime();
        log.info("33333查询时间 :{}", (endTime3 - beginTime3) + "ns");
        session3.close();

        long beginTime = System.nanoTime();
        List<ProductDo> ls = mapper.queryProDetails();
        long endTime = System.nanoTime();
        log.info("查询时间 :{}", (endTime - beginTime) + "ns");
        session.close();

        log.info("ls1={}", ls1.size());
        log.info("ls2={}", ls2.size());
        log.info("ls3={}", ls3.size());
        log.info("ls={}", ls.size());
    }

    @Test
    public void testQueryProDetails1() throws Exception {

        ProductMapper mapper = session.getMapper(ProductMapper.class);

        long beginTime = System.nanoTime();
        List<ProductDo> ls = mapper.queryProDetails();
        long endTime = System.nanoTime();
        log.info("查询时间 :{}", (endTime - beginTime) + "ns");
        session.close();

        log.info("ls={}", ls.size());
    }

    @Test
    public void testQueryProDetailsPage() throws Exception{
        ProductMapper mapper = session.getMapper(ProductMapper.class);

        List<ProductDo> ls = mapper.queryProDetailsPage();
        log.info("ls {}",ls.size());
    }

}