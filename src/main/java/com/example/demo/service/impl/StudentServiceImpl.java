package com.example.demo.service.impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findStudentByName(String name) {
        return studentMapper.findStudentByName(name);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.insertSelective(student);
    }
}
