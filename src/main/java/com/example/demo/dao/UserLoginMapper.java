package com.example.demo.dao;

import com.example.demo.entity.UserLogin;

import java.util.List;

public interface UserLoginMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);

    UserLogin findUserByUsername(String username);

    List<UserLogin> selectAll();
}