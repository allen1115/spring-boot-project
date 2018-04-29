package com.example.demo.service;

import com.example.demo.entity.AttendanceThresholdConfig;

import java.util.List;

public interface AttendanceThresholdConfigService {

    AttendanceThresholdConfig getAttendanceThresholdConfigById(int id);

    AttendanceThresholdConfig getAllConfig();
}
