package com.example.demo.service.impl;

import com.example.demo.dao.StudentAttendanceMapper;
import com.example.demo.dao.StudentMapper;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Student findStudentByEmail(String email) {
        return studentMapper.findStudentByEmail(email);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public int updateStudentAvgAttendance(Long studentId) {
        // 查询学生的总出席率和出席次数, 计算平均数
        Map<String, Object> map = studentAttendanceMapper.getTotalAttendanceAndCount(studentId);
        Double sumAttendance = (Double) map.get("sumAttendance");
        Integer totalCount = ((Long)map.get("totalCount")).intValue();
        // 更新学生的平均出席率
        return studentMapper.updateAvgAttendance(studentId, sumAttendance / totalCount);
    }

    @Override
    public List<Student> findAllUsers() {
        return studentMapper.selectAllUsers();
    }

    @Override
    public int updateByPrimaryKeySelective(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }
}
