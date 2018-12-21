package com.zl.mybatis.dao;

import com.zl.mybatis.com.zl.mybatis.pojo.User;
import com.zl.mybatis.dao.impl.UserDaoImpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class UserDaoTest {

    public UserDao userDao;
    public SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        sqlSession = sessionFactory.openSession();
        this.userDao = new UserDaoImpl(sqlSession);
    }

    @Test
    public void queryUserById() {
        System.out.println("查询id为1的用户：" + this.userDao.queryUserById("1"));
    }

    @Test
    public void queryUserAll() {
        List<User> userList = this.userDao.queryUserAll();
        for (User user : userList) {
            System.out.println("查询全部的用户：" + user);
        }
    }

    @Test
    public void insertUser() {
//        User user = new User();
//        user.setId("102");
//        user.setAge(26);
//        user.setBirthday(new Date("1990/09/02"));
//        user.setName("磊磊");
//        user.setPassword("123456");
//        user.setSex(1);
//        user.setUserName("嗯嗯");
//
//        this.userDao.insertUser(user);
//
//        this.sqlSession.commit();
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId("203");
        user.setBirthday(new Date());
        user.setName("萱萱");
        user.setPassword("654321");
        user.setSex(1);
        user.setUserName("哦哦");
        this.userDao.updateUser(user);
        this.sqlSession.commit();
    }

    @Test
    public void deleteUser() {
//        this.userDao.deleteUser("4");
//        this.sqlSession.commit();
    }
}