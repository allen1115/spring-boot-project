package com.example.demo.dao;

import com.example.demo.entity.EmailInterval;
import org.apache.ibatis.annotations.Param;

public interface EmailIntervalMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EmailInterval record);

    int insertSelective(EmailInterval record);

    EmailInterval selectByPrimaryKey(@Param("id") Long id);

    int updateByPrimaryKeySelective(EmailInterval record);

    int updateByPrimaryKey(EmailInterval record);
}