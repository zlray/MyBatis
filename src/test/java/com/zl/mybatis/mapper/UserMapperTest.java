package com.zl.mybatis.mapper;

import com.zl.mybatis.mapper.UserMapper;
import com.zl.mybatis.pojo.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class UserMapperTest {
    public UserMapper userMapper;

    @Before
    public void setUp() throws IOException {
        // 指定配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession,自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 1. 映射文件的命名空间（namespace）必须是mapper接口的全路径
        // 2. 映射文件的statement的id必须和mapper接口的方法名保持一致
        // 3. Statement的resultType必须和mapper接口方法的返回类型一致
        // 4. statement的parameterType必须和mapper接口方法的参数类型一致（不一定）
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void login() {
        System.out.println(this.userMapper.login("zl", "123456"));
    }

    @Test
    public void queryUserByTableName() {
        //
        List<User> userList = this.userMapper.queryUserByTableName("tb_user");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserById() {
        System.out.println("查询id为" + 1 + "的用户：" + this.userMapper.queryUserById(1));
    }

    @Test
    public void queryUserAll() {
        List<User> userList = this.userMapper.queryUserAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("bigGod222");
        user.setName("大神");
        user.setPassword("123456");
        user.setAge(20);
        user.setSex(2);
        user.setBirthday(new Date());
        this.userMapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("静静");
        user.setPassword("123456");
        user.setSex(0);
        user.setUsername("Jinjin");
        user.setId(100);
        this.userMapper.updateUser(user);
    }

    @Test
    public void deleteUserById() {
        this.userMapper.deleteUserById(1);
    }
}