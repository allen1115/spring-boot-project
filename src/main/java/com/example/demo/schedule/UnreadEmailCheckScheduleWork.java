package com.example.demo.schedule;

import com.example.demo.entity.EmailLog;
import com.example.demo.entity.RepliedEmailLog;
import com.example.demo.entity.Student;
import com.example.demo.service.impl.CronServiceImpl;
import com.example.demo.service.impl.EmailLogServiceImpl;
import com.example.demo.service.impl.RepliedEmailLogServiceImpl;
import com.example.demo.service.impl.StudentServiceImpl;
import com.example.demo.util.MailUtil;
import com.example.demo.util.PropertiesUtil;
import com.example.demo.util.UUIDUtil;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Component
public class UnreadEmailCheckScheduleWork implements SchedulingConfigurer {

    @Autowired
    private CronServiceImpl cronService;

    @Autowired
    private RepliedEmailLogServiceImpl repliedEmailLogService;

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private EmailLogServiceImpl emailLogService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                this::checkUnreadEmail,
                triggerContext -> {
                    String cron = cronService.getCronExpression(3L).getCron();
                    StringUtils.isEmpty(cron);
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }

    private void checkUnreadEmail() {
        PropertiesUtil properties = new PropertiesUtil("mail");
        Properties prop = System.getProperties();
        prop.put("mail.store.protocol", "imap");
        prop.put("mail.imap.host", properties.getValue("mail.imap.service"));

        Session session = Session.getInstance(prop);

        IMAPStore store; // use imap
        try {
            store = (IMAPStore) session.getStore("imap");
            store.connect(properties.getValue("mail.from.address"), properties.getValue("mail.from.imap.pwd"));
            IMAPFolder folder = (IMAPFolder) store.getFolder("INBOX"); // Inbox
            folder.open(Folder.READ_WRITE);
            // get total numbers of email
            int total = folder.getMessageCount();
            System.out.println("-----------------Total ：" + total
                    + " emails--------------");
            System.out.println("---------------Total : " + folder.getUnreadMessageCount() + "unread emails-------------");
            Message[] messages = folder.getMessages(folder.getMessageCount() - folder.getUnreadMessageCount() + 1, folder.getMessageCount());
            for (int i = 0, count = messages.length; i < count; i++) {
                MimeMessage msg = (MimeMessage) messages[i];
                Flags flags = messages[i].getFlags();
                if (!flags.contains(Flags.Flag.SEEN)) {
                    // set email to read
                    msg.setFlag(Flags.Flag.SEEN, true);
                    System.out.println("------------------Analyse the " + msg.getMessageNumber() + "of unread email-------------------- ");
                    System.out.println("Subject: " + MailUtil.getSubject(msg));
                    System.out.println("From: " + MailUtil.getFrom(msg));
                    System.out.println("To：" + MailUtil.getReceiveAddress(msg, null));
                    System.out.println("Date：" + MailUtil.getSentDate(msg, null));
                    System.out.println("Priority：" + MailUtil.getPriority(msg));
                    System.out.println("Need reply：" + MailUtil.isReplySign(msg));
                    System.out.println("Mail size：" + msg.getSize() * 1024 + "kb");
                    boolean isContainerAttachment = MailUtil.isContainAttachment(msg);
                    System.out.println("Include attachment：" + isContainerAttachment);
                    if (isContainerAttachment) {
                        // TODO need change directory
                        MailUtil.saveAttachment(msg, "f:\\mailTest\\" + msg.getSubject() + "_" + i + "_"); //保存附件
                    }
                    StringBuffer content = new StringBuffer(30);
                    MailUtil.getMailTextContent(msg, content);
                    System.out.println("Content：" + (content.length() > 100 ? content.substring(0, 100) + "..." : content));
                    System.out.println("------------------The" + msg.getMessageNumber() + "of unread analyze finish-------------------- ");
                    System.out.println();

                    // add record to replied_email_log
                    RepliedEmailLog repliedEmailLog = new RepliedEmailLog();
                    repliedEmailLog.setEmailSubject(MailUtil.getSubject(msg));
                    repliedEmailLog.setEmailBody(content.toString());
                    repliedEmailLog.setAbsenceReason(extractAbsenceReason(content.toString()));
                    repliedEmailLog.setRepliedDate(msg.getSentDate());
                    repliedEmailLog.setRepliedEmailLogId(UUIDUtil.getUUID());
                    addRepliedEmailLog(repliedEmailLog);

                    // update email_log
                    Student student = studentService.findStudentByEmail(MailUtil.getFromAddr(msg));
                    EmailLog emailLog = emailLogService.findEmailLogByEmailLogId(student.getEmailLogId());
                    emailLog.setRepliedEmailId(repliedEmailLog.getRepliedEmailLogId());
                    emailLog.setIsReplied("TRUE");
                    emailLogService.updateSelective(emailLog);
                    System.out.println("============================update completed");
                }
            }

            // 释放资源
            folder.close(true);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addRepliedEmailLog(RepliedEmailLog repliedEmailLog) {
        repliedEmailLogService.insertSelective(repliedEmailLog);
    }

    private String extractAbsenceReason(String content) {
        // TODO need add logic to extract reason
        return "Absence Reason";
    }
}
