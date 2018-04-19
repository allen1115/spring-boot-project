package com.example.demo.schedule;

import com.example.demo.entity.AttendanceThresholdConfig;
import com.example.demo.entity.EmailTemplate;
import com.example.demo.entity.Student;
import com.example.demo.mail.MailContentTypeEnum;
import com.example.demo.mail.MailSender;
import com.example.demo.service.AttendanceThresholdConfigService;
import com.example.demo.service.CronService;
import com.example.demo.service.EmailTemplateService;
import com.example.demo.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AttendanceCheckScheduleWork implements SchedulingConfigurer {

    @Autowired
    private CronService cronService;

    @Autowired
    private AttendanceThresholdConfigService attendanceThresholdConfigService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EmailTemplateService emailTemplateService;


//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//        System.out.println("现在时间：" + dateFormat.format(new Date()));
//    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                this::checkAttendance,
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = cronService.getCronExpression(1L).getCron();
                    //2.2 合法性校验.
                    StringUtils.isEmpty(cron);
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }

    private void checkAttendance() {
        // 获取设定的attendance threshold
        AttendanceThresholdConfig config = attendanceThresholdConfigService.getAttendanceThresholdConfigById(1);
        Double firstLevel = config.getFirstLevel();
        Double secondLevel = config.getSecondLevel();
        Double thirdLevel = config.getThirdLevel();
        // 获取每一个学生的出勤率
        List<Student> students = studentService.findAllUsers();
        for (Student student: students) {
            Double avgAttendance = student.getAvgAttendance();
            if(avgAttendance <= thirdLevel) {
                // 第三级别
                //TODO 发送第三级别邮件
                sendEmail("third", student);
                System.out.println("学生姓名: " + student.getName() + " 学生出勤率: " + avgAttendance + " 第三级别");
            } else if(avgAttendance <= secondLevel) {
                // 第二级别
                // TODO 发送第二级别邮件
                sendEmail("second", student);
                System.out.println("学生姓名: " + student.getName() + " 学生出勤率: " + avgAttendance + " 第二级别");
            } else if(avgAttendance <= firstLevel) {
                // 第一级别
                // TODO 发送第一级别邮件
                sendEmail("first", student);
                System.out.println("学生姓名: " + student.getName() + " 学生出勤率: " + avgAttendance + " 第一级别");
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
