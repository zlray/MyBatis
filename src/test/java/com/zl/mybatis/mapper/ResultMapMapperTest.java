package com.zl.mybatis.mapper;

import com.zl.mybatis.pojo.User;
import com.zl.mybatis.utils.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ResultMapMapperTest {

    ResultMapMapper mResultMapMapper;

    @Before
    public void setUp() throws Exception {

        SqlSession session = MyBatisUtil.getSqlSession(true);

        mResultMapMapper = session.getMapper(ResultMapMapper.class);

    }

    @Test
    public void queryUserByTableName() {
        List<User> list = mResultMapMapper.queryUserByTableName("tb_user");
        for (User user : list){
            System.out.println(user);
        }

    }
}