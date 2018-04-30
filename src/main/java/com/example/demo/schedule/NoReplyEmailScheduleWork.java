package com.example.demo.schedule;

import com.example.demo.entity.EmailInterval;
import com.example.demo.entity.EmailLog;
import com.example.demo.entity.EmailTemplate;
import com.example.demo.entity.Student;
import com.example.demo.mail.MailContentTypeEnum;
import com.example.demo.mail.MailSender;
import com.example.demo.service.CronService;
import com.example.demo.service.impl.EmailIntervalServiceImpl;
import com.example.demo.service.impl.EmailLogServiceImpl;
import com.example.demo.service.impl.EmailTemplateServiceImpl;
import com.example.demo.service.impl.StudentServiceImpl;
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
public class NoReplyEmailScheduleWork implements SchedulingConfigurer {

    @Autowired
    private CronService cronService;

    @Autowired
    private EmailIntervalServiceImpl emailIntervalService;

    @Autowired
    private EmailLogServiceImpl emailLogService;

    @Autowired
    private EmailTemplateServiceImpl emailTemplateService;

    @Autowired
    private StudentServiceImpl studentService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        //                    System.out.println(thread.getName() + new Date());
        scheduledTaskRegistrar.addTriggerTask(
                this::checkNoReplyEmail,
                triggerContext -> {
                    String cron = cronService.getCronExpression(2L).getCron();
                    StringUtils.isEmpty(cron);
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }

    private void checkNoReplyEmail(){
        // get time interval
        EmailInterval emailInterval = emailIntervalService.getEmailInterval();
        // get email sent previously
        List<EmailLog> emailLogList = emailLogService.findAll();
        for (EmailLog emailLog : emailLogList) {
            if((new Date().getTime() - emailLog.getCreateDate().getTime())/1000 * 24 * 60 * 60 >= emailInterval.getInterval() && emailLog.getIsSentAlert().equals("FALSE")) {
                // need send higher
                // get email template
                EmailTemplate emailTemplate = emailTemplateService.getEmailTemplateByLevel("Second Alert");
                // get student info by email_log_id
                Student student = studentService.findStudentByEmailLogId(emailLog.getEmailLogId());
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
    }
}
