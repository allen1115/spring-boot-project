package com.example.demo.dao;

import com.example.demo.entity.EmailLog;

import java.util.List;

public interface EmailLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EmailLog record);

    int insertSelective(EmailLog record);

    EmailLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EmailLog record);

    int updateByPrimaryKey(EmailLog record);

    EmailLog findEmailLogByEmailLogId(String emailLogId);

    List<EmailLog> selectAll();
}