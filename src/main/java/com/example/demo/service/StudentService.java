package com.example.demo.service;

import com.example.demo.entity.Student;

public interface StudentService {

    Student findStudentByName(String name);

    int addStudent(Student student);
}
