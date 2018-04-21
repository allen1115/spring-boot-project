package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {

    Student findStudentByName(String name);

    Student findStudentByEmail(String email);

    int addStudent(Student student);

    int updateStudentAvgAttendance(Long studentId);

    List<Student> findAllUsers();

    int updateByPrimaryKeySelective(Student student);
}
