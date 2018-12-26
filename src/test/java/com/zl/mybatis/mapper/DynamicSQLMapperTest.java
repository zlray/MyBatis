package com.zl.mybatis.mapper;

import com.zl.mybatis.pojo.User;
import com.zl.mybatis.utils.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DynamicSQLMapperTest {

    DynamicSQLMapper mDynamicSQLMapper;

    @Before
    public void setUp() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

        mDynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
    }

    @Test
    public void queryUserList() {
        List<User> list = mDynamicSQLMapper.queryUserList("zl");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserListByNameOrAge(){
        List<User> users = mDynamicSQLMapper.queryUserListByNameOrAge("zl", 16);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserListByIds(){
        List<User> users = mDynamicSQLMapper.queryUserListByIds(new String[]{"1","2"});
        for (User user : users) {
            System.out.println(user);
        }
    }
}