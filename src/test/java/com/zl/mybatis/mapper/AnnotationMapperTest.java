package com.zl.mybatis.mapper;

import com.zl.mybatis.mapper.AnnotationMapper;
import com.zl.mybatis.pojo.User;
import com.zl.mybatis.utils.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class AnnotationMapperTest {

    AnnotationMapper mAnnotationMapper;
    SqlSession mSqlSession;

    @Before
    public void setUp() throws Exception {

        //
        mSqlSession = MyBatisUtil.getSqlSession(true);

        mAnnotationMapper = mSqlSession.getMapper(AnnotationMapper.class);
    }

    @Test
    public void login() {
        System.out.println("验证登录：" + mAnnotationMapper.login("zl2", "12345678"));
    }

    @Test
    public void queryUserByTableName() {
        List<User> userList = mAnnotationMapper.queryUserByTableName("tb_user");
        for (User user : userList) {
            System.out.println("查询全部：" + user);
        }
    }

    @Test
    public void queryUserById() {
        System.out.println("查询id为3：" + mAnnotationMapper.queryUserById(3));
    }

    @Test
    public void queryUserAll() {
        List<User> userList = mAnnotationMapper.queryUserAll();
        for (User user : userList) {
            System.out.println("查询全部：" + user);
        }
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("insert");
        user.setName("插入数据");
        user.setPassword("123456");
        user.setAge(20);
        user.setSex(2);
        user.setBirthday(new Date());
        user.setCreated(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        user.setUpdated(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        this.mAnnotationMapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setBirthday(new Date());
        user.setId(10);
        user.setUsername("annotation");
        user.setPassword("123456");
        user.setName("修改id为10");
        user.setAge(26);
        user.setSex(0);
        user.setBirthday(new Date());
        user.setCreated(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        user.setCreated(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        mAnnotationMapper.updateUser(user);
    }

    @Test
    public void deleteUserById() {
        mAnnotationMapper.deleteUserById(14);
    }
}