package com.example.demo.dao;

import com.example.demo.entity.AttendanceThresholdConfig;

import java.util.List;

public interface AttendanceThresholdConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AttendanceThresholdConfig record);

    int insertSelective(AttendanceThresholdConfig record);

    AttendanceThresholdConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AttendanceThresholdConfig record);

    int updateByPrimaryKey(AttendanceThresholdConfig record);

    AttendanceThresholdConfig getAllConfig();
}