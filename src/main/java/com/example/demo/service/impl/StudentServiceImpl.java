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
        // query total of students' attendance and calculate avg
        Map<String, Object> map = studentAttendanceMapper.getTotalAttendanceAndCount(studentId);
        Double sumAttendance = (Double) map.get("sumAttendance");
        Integer totalCount = ((Long)map.get("totalCount")).intValue();
        // update students' avg attendance
        return studentMapper.updateAvgAttendance(studentId, sumAttendance / totalCount);
    }

    @Override
    public List<Student> findAllUsersWithNullEmailId() {
        return studentMapper.selectAllUsersWithNullEmailId();
    }

    @Override
    public List<Student> findAllStudents() {
        return studentMapper.selectAllStudents();
    }

    @Override
    public int updateByPrimaryKeySelective(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public int markAsRedById(Long aLong) {
        return studentMapper.markAsRedById(aLong);
    }

    @Override
    public int markAsBlueById(Long aLong) {
        return studentMapper.markAsBlueById(aLong);
    }

    @Override
    public int unMark(Long aLong) {
        return studentMapper.unMark(aLong);
    }

    @Override
    public Student findStudentByEmailLogId(String emailLogId) {
        return studentMapper.selectStudentByEmailLogId(emailLogId);
    }
}
