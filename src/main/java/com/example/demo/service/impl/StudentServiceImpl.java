package com.example.demo.service.impl;

import com.example.demo.dao.StudentAttendanceMapper;
import com.example.demo.dao.StudentMapper;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentAttendanceMapper studentAttendanceMapper;

    @Override
    public Student findStudentByName(String name) {
        return studentMapper.findStudentByName(name);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public int updateStudentAvgAttendance(Long studentId) {
        // 查询学生的总出席率和出席次数, 计算平均数
        Map<Double, Integer> map = studentAttendanceMapper.getTotalAttendanceAndCount(studentId);
        for (Map.Entry<Double, Integer> entry: map.entrySet()) {
            Double totalAttendance = entry.getKey();
            Integer totalCount = entry.getValue();
            Double avgAttendance = totalAttendance / totalCount;

        }
        return 0;
    }
}
