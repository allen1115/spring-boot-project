package com.example.demo.dao;

import com.example.demo.entity.Module;

public interface ModuleMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}