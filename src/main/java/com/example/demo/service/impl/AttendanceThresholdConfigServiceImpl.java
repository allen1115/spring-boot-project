package com.example.demo.service.impl;

import com.example.demo.dao.AttendanceThresholdConfigMapper;
import com.example.demo.entity.AttendanceThresholdConfig;
import com.example.demo.service.AttendanceThresholdConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceThresholdConfigServiceImpl implements AttendanceThresholdConfigService {

    @Autowired
    private AttendanceThresholdConfigMapper attendanceThresholdConfigMapper;

    @Override
    public AttendanceThresholdConfig getAttendanceThresholdConfigById(int id) {
        return attendanceThresholdConfigMapper.selectByPrimaryKey(id);
    }
}
