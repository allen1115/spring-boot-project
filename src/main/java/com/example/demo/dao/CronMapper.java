package com.example.demo.dao;

import com.example.demo.entity.Cron;

public interface CronMapper {
    int deleteByPrimaryKey(Long cronId);

    int insert(Cron record);

    int insertSelective(Cron record);

    Cron selectByPrimaryKey(Long cronId);

    int updateByPrimaryKeySelective(Cron record);

    int updateByPrimaryKey(Cron record);
}