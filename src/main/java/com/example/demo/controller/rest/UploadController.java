package com.example.demo.controller.rest;

import au.com.bytecode.opencsv.CSVReader;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentAttendance;
import com.example.demo.service.StudentAttendanceService;
import com.example.demo.service.StudentService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.List;

@RestController
@RequestMapping("/uploadFile")
public class UploadController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentAttendanceService studentAttendanceService;

    @RequestMapping("/upload.json")
    public String uploadFile(@RequestParam("file")MultipartFile uploadFile) throws Exception {
        String fileName = uploadFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.indexOf("."), fileName.length());
        if(suffix.equals(".xlsx")) {
            FileInputStream fs = (FileInputStream)uploadFile.getInputStream();
            // get Excel object
            XSSFWorkbook wb = new XSSFWorkbook(fs);

            // get Sheet object
            XSSFSheet sheet = wb.getSheetAt(0);
            int totalNum = 0;

            // read excel data
            for (int i = 1; i <= sheet.getLastRowNum(); i ++) {
                XSSFRow row = sheet.getRow(i);
                StudentAttendance s = new StudentAttendance();
                // get student name & id, if not exist, create new student
                String name = row.getCell(2).toString();
                Student student = studentService.findStudentByName(name);
                if(student == null) {
                    // create new student
                    Student newStudent = new Student();
                    newStudent.setEmail(row.getCell(3).toString());
                    newStudent.setName(name);
                    newStudent.setStatus("ACTIVE");
                    newStudent.setTier_4(row.getCell(12).toString().toLowerCase().equals("yes")?"TRUE":"FALSE");
                    int num = studentService.addStudent(newStudent);
                    if(num >= 1) {
                        s.setStudentId(studentService.findStudentByName(name).getId());
                    }
                } else {
                    s.setStudentId(student.getId());
                }

                // course_name
                s.setCourseName(row.getCell(5).getStringCellValue());

                // course_code
                s.setCourseCode(row.getCell(6).getStringCellValue());

                // attended
                s.setAttended((long)row.getCell(7).getNumericCellValue());

                // explainedAbsence
                s.setExplainedAbsence((long)row.getCell(8).getNumericCellValue());

                // sessions
                s.setSessions((long)row.getCell(9).getNumericCellValue());

                // attendance
                s.setAttendance(row.getCell(10).getNumericCellValue() * 100);

                int num = studentAttendanceService.addStudentAttendance(s);
                studentService.updateStudentAvgAttendance(s.getStudentId());
                totalNum += num;
            }

            System.out.println("total number: " + totalNum);
        } else {
            // CSV file
            File f = null;
            f = File.createTempFile("temp", null);
            uploadFile.transferTo(f);
            f.deleteOnExit();
            FileReader fReader = new FileReader(f);
            CSVReader csvReader = new CSVReader(fReader);
            csvReader.readNext();
            List<String[]> list = csvReader.readAll();
            int totalNum = 0;
            for (String[] ss: list) {
                StudentAttendance s = new StudentAttendance();
                String name = ss[2];
                Student student = studentService.findStudentByName(name);
                if(student == null) {
                    // create new student
                    Student newStudent = new Student();
                    newStudent.setEmail(ss[3]);
                    newStudent.setName(name);
                    newStudent.setStatus("ACTIVE");
                    newStudent.setTier_4(ss[12].toLowerCase().equals("yes")?"TRUE":"FALSE");
                    int num = studentService.addStudent(newStudent);
                    if(num >= 1) {
                        s.setStudentId(studentService.findStudentByName(name).getId());
                    }
                } else {
                    s.setStudentId(student.getId());
                }

                // course_name
                s.setCourseName(ss[5]);

                // course_code
                s.setCourseCode(ss[6]);

                // attended
                s.setAttended(Long.parseLong(ss[7]));

                // explainedAbsence
                s.setExplainedAbsence(Long.parseLong(ss[8]));

                // sessions
                s.setSessions(Long.parseLong(ss[9]));

                // attendance
                System.out.println(ss[10] + " " + ss[10].length());
                s.setAttendance(Double.parseDouble(ss[10].substring(0, ss[10].length()-1)));

                int num = studentAttendanceService.addStudentAttendance(s);
                studentService.updateStudentAvgAttendance(s.getId());
                totalNum += num;
            }
            System.out.println("total number: " + totalNum);
            csvReader.close();
        }

        return "success";
    }
}
