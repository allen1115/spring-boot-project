package com.example.demo.controller.rest;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Student;
import com.example.demo.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

    @RequestMapping(value = "/markAsRed", method = RequestMethod.POST)
    public int markAsRed(@RequestParam(value = "data[]") Long[] param) {
        int total = 0;
        for (Long aParam : param) {
            int i = studentService.markAsRedById(aParam);
            total += i;
        }
        return total;
    }

    @RequestMapping(value = "/markAsBlue", method = RequestMethod.POST)
    public int markAsBlue(@RequestParam(value = "data[]") Long[] param) {
        int total = 0;
        for (Long aParam : param) {
            int i = studentService.markAsBlueById(aParam);
            total += i;
        }
        return total;
    }

    @RequestMapping(value = "/unMark", method = RequestMethod.POST)
    public int unMark(@RequestParam(value = "data[]") Long[] param) {
        int total = 0;
        for (Long aParam : param) {
            int i = studentService.unMark(aParam);
            total += i;
        }
        return total;
    }

    @RequestMapping(value = "/updateNote", method = RequestMethod.POST)
    public int updateNote(@RequestBody JSONObject param) {
        Student student = new Student();
        student.setId(param.getLong("id"));
        student.setNote(param.getString("note"));
        return studentService.updateByPrimaryKeySelective(student);
    }
}
