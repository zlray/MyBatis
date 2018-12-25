package com.zl.mybatis.mapper;

import com.zl.mybatis.mapper.UserDao;
import com.zl.mybatis.pojo.User;
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
    private int i = 1;

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
        System.out.println("查询id为" + 1 + "的用户：" + this.userDao.queryUserById(1));
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
        i++;
        User user = new User();
        user.setId(i);
        user.setUsername("zl" + i);
        user.setPassword("123456");
        user.setName("磊" + i);
        user.setAge(26);
        user.setSex(1);
        user.setBirthday(new Date("1990/09/02"));
        this.userDao.insertUser(user);
        this.sqlSession.commit();
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("zl");
        user.setPassword("123456");
        user.setName("磊");
        user.setAge(62);
        user.setSex(1);
        user.setBirthday(new Date());
        this.userDao.updateUser(user);
        this.sqlSession.commit();
    }

    @Test
    public void deleteUser() {
        this.userDao.deleteUser(9);
        this.sqlSession.commit();
    }
}