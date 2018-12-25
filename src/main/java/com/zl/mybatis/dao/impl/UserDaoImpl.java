package com.zl.mybatis.dao.impl;

import com.zl.mybatis.pojo.User;
import com.zl.mybatis.mapper.UserDao;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    public User queryUserById(int id) {
        return this.sqlSession.selectOne("UserDao.queryUserById", id);

    }

    public List<User> queryUserAll() {
        return this.sqlSession.selectList("UserDao.queryUserAll");
    }

    public void insertUser(User user) {
        this.sqlSession.insert("UserDao.insertUser", user);
    }

    public void updateUser(User user) {
        this.sqlSession.update("UserDao.updateUser", user);
    }

    public void deleteUser(int id) {
        this.sqlSession.delete("UserDao.deleteUser", id);
    }
}
