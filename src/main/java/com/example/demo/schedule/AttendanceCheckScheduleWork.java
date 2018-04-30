package com.example.demo.schedule;

import com.example.demo.entity.AttendanceThresholdConfig;
import com.example.demo.entity.EmailLog;
import com.example.demo.entity.EmailTemplate;
import com.example.demo.entity.Student;
import com.example.demo.mail.MailContentTypeEnum;
import com.example.demo.mail.MailSender;
import com.example.demo.service.impl.*;
import com.example.demo.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AttendanceCheckScheduleWork implements SchedulingConfigurer {

    @Autowired
    private CronServiceImpl cronService;

    @Autowired
    private AttendanceThresholdConfigServiceImpl attendanceThresholdConfigService;

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private EmailTemplateServiceImpl emailTemplateService;

    @Autowired
    private EmailLogServiceImpl emailLogService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                //1.add task content(Runnable)
                this::checkAttendance,
                //2.set period(Trigger)
                triggerContext -> {
                    //2.1 get cron from database
                    String cron = cronService.getCronExpression(1L).getCron();
                    //2.2 validation
                    StringUtils.isEmpty(cron);
                    //2.3 return cron(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }

    private void checkAttendance() {
        // get attendance threshold
        AttendanceThresholdConfig config = attendanceThresholdConfigService.getAttendanceThresholdConfigById(1);
        Double firstLevel = config.getFirstLevel();
        Double secondLevel = config.getSecondLevel();
        Double thirdLevel = config.getThirdLevel();
        // get attendance for each student
        List<Student> students = studentService.findAllUsersWithNullEmailId();
        for (Student student: students) {
            Double avgAttendance = student.getAvgAttendance();
            if(avgAttendance <= thirdLevel) {
                // third level
                sendEmail("third", student);
                System.out.println("Student name: " + student.getName() + " Attendance: " + avgAttendance + " third level");
            } else if(avgAttendance <= secondLevel) {
                // second level
                sendEmail("second", student);
                System.out.println("Student name: " + student.getName() + " Attendance: " + avgAttendance + " second level");
            } else if(avgAttendance <= firstLevel) {
                // first level
                sendEmail("first", student);
                System.out.println("Student name: " + student.getName() + " Attendance: " + avgAttendance + " first level");
            }
        }
    }

    private void sendEmail(String level, Student student) {
        EmailTemplate emailTemplate = emailTemplateService.getEmailTemplateByLevel(level);
        try {
            new MailSender()
                    .title(emailTemplate.getTemplateName())
                    .content(emailTemplate.getTemplateBody())
                    .contentType(MailContentTypeEnum.TEXT)
                    .targets(new ArrayList<String>(){{add(student.getEmail());}})
                    .send();
            // add record to email_log
            EmailLog emailLog = new EmailLog();
            emailLog.setIsReplied("FALSE");
            emailLog.setCreateDate(new Date());
            emailLog.setUpdateDate(new Date());
            emailLog.setEmailLogId(UUIDUtil.getUUID());
            emailLog.setIsReplied("FALSE");
            addEmailLog(emailLog);
            // update student info
            student.setEmailLogId(emailLog.getEmailLogId());
            studentService.updateByPrimaryKeySelective(student);
            System.out.println("===========================update completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addEmailLog(EmailLog emailLog) {
        emailLogService.insertSelective(emailLog);
    }
}
