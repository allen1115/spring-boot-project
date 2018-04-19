package com.example.demo.dao;

import com.example.demo.entity.RepliedEmailLog;

public interface RepliedEmailLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RepliedEmailLog record);

    int insertSelective(RepliedEmailLog record);

    RepliedEmailLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RepliedEmailLog record);

    int updateByPrimaryKey(RepliedEmailLog record);
}