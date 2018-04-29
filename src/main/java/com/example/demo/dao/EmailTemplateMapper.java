package com.example.demo.dao;

import com.example.demo.entity.EmailTemplate;

import java.util.List;

public interface EmailTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmailTemplate record);

    int insertSelective(EmailTemplate record);

    EmailTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmailTemplate record);

    int updateByPrimaryKey(EmailTemplate record);

    EmailTemplate selectByLevel(String level);

    List<EmailTemplate> selectAll();
}