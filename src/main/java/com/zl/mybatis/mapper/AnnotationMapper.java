package com.zl.mybatis.mapper;

import com.zl.mybatis.pojo.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AnnotationMapper {

    /**
     * 登录（直接使用注解指定传入参数名称）
     *
     * @param username
     * @param password
     * @return
     */
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User login(@Param("username") String username, @Param("password") String password);

    /**
     * 根据表名查询用户信息（直接使用注解指定传入参数名称）
     *
     * @param tableName
     * @return
     */
    @Select("select * from ${tableName}")
    List<User> queryUserByTableName(@Param("tableName") String tableName);

    /**
     * 根据Id查询用户信息
     *
     * @param id
     * @return
     */
    @Select("select * from tb_user where id = #{id}")
    User queryUserById(int id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Select("select * from tb_user")
    List<User> queryUserAll();

    /**
     * 新增用户信息
     *
     * @param user
     */
    @Insert("insert into tb_user(id,username,password,name,age,sex,birthday,created,updated)" +
            "values(#{id},#{username},#{password},#{name},#{age},#{sex},#{birthday},#{created},#{updated})")
    void insertUser(User user);

    /**
     * 根据id更新用户信息
     *
     * @param user
     */
    @Update("update tb_user set username = #{username},password = #{password} where id = #{id}")
    void updateUser(User user);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    @Delete("delete from tb_user where id = #{id}")
    void deleteUserById(int id);

}
