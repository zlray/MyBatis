package com.zl.mybatis.mapper;

import com.zl.mybatis.pojo.User;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResultMapMapper {

    /**
     *
     * @param tableName
     * @return
     */
    List<User> queryUserByTableName(@Param("tableName") String tableName);


}
