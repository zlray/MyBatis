package com.zl.mybatis.mapper;

import com.zl.mybatis.pojo.User;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {

    /**
     * 查询男性用户，如果输入了姓名，则按姓名查询
     * @param username
     * @return
     */
    List<User> queryUserList(@Param("username") String username);


    /**
     * 查询男性用户，如果输入了姓名则按照姓名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找姓名为“鹏程”的用户。
     * @param username
     * @param age
     * @return
     */
    List<User> queryUserListByNameOrAge(@Param("username") String username,@Param("age") Integer age);


    /**
     * 按多个Id查询
     * @param ids
     * @return
     */
    List<User> queryUserListByIds(@Param("ids") String[] ids);

}
