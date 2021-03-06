package com.example.demo.dao;

import com.example.demo.entity.StudentAttendance;

import java.util.Map;

public interface StudentAttendanceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudentAttendance record);

    int insertSelective(StudentAttendance record);

    StudentAttendance selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StudentAttendance record);

    int updateByPrimaryKey(StudentAttendance record);

    Map<String, Object> getTotalAttendanceAndCount(Long id);
}