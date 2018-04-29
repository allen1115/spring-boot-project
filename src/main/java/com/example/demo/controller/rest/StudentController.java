package com.example.demo.controller.rest;

import com.example.demo.entity.Student;
import com.example.demo.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
