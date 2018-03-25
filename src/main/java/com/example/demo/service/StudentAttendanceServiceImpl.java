package com.example.demo.service;

import com.example.demo.dao.StudentAttendanceMapper;
import com.example.demo.entity.StudentAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentAttendanceServiceImpl implements StudentAttendanceService {

    @Autowired
    private StudentAttendanceMapper studentAttendanceMapper;

    @Override
    public int addStudentAttendance(StudentAttendance studentAttendance) {
        return studentAttendanceMapper.insertSelective(studentAttendance);
    }
}
