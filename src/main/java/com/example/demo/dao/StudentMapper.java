package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student findStudentByName(String name);

    int updateAvgAttendance(@Param("id") Long id, @Param("avgAttendance") Double avgAttendance);

    List<Student> selectAllUsersWithNullEmailId();

    List<Student> selectAllStudents();

    Student findStudentByEmail(String email);

    int markAsRedById(Long aLong);

    int markAsBlueById(Long aLong);

    Student selectStudentByEmailLogId(@Param("emailLogId")String emailLogId);

    int unMark(Long aLong);
}