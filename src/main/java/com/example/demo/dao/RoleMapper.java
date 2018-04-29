package com.example.demo.dao;

import com.example.demo.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAll();

    int addRoleToUser(@Param("rid") Long rid, @Param("uid") Long uid);

    int assignRoleToUser(@Param("rid") Long rid, @Param("uid") Long uid);

    int deleteRoleModule(@Param("rid") Integer rid);

    int assignRoleModule(@Param("rid") Long rid, @Param("pid") Long pid);
}