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
                //1.添加任务内容(Runnable)
                this::checkUnreadEmail,
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = cronService.getCronExpression(3L).getCron();
                    //2.2 合法性校验.
                    StringUtils.isEmpty(cron);
                    //2.3 返回执行周期(Date)
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

        IMAPStore store; // 使用imap会话机制，连接服务器
        try {
            store = (IMAPStore) session.getStore("imap");
            store.connect(properties.getValue("mail.from.address"), properties.getValue("mail.from.imap.pwd"));
            IMAPFolder folder = (IMAPFolder) store.getFolder("INBOX"); // 收件箱
            folder.open(Folder.READ_WRITE);
            // 获取总邮件数
            int total = folder.getMessageCount();
            System.out.println("-----------------共有邮件：" + total
                    + " 封--------------");
            System.out.println("---------------共有未读邮件: " + folder.getUnreadMessageCount() + "封-------------");
            // 得到收件箱文件夹信息，获取邮件列表
            System.out.println("未读邮件数：" + folder.getUnreadMessageCount());
            Message[] messages = folder.getMessages(folder.getMessageCount() - folder.getUnreadMessageCount() + 1, folder.getMessageCount());
            for (int i = 0, count = messages.length; i < count; i++) {
                MimeMessage msg = (MimeMessage) messages[i];
                Flags flags = messages[i].getFlags();
                if (!flags.contains(Flags.Flag.SEEN)) {
                    // 设置邮件已读
                    msg.setFlag(Flags.Flag.SEEN, true);
                    System.out.println("------------------解析第" + msg.getMessageNumber() + "封未读邮件-------------------- ");
                    System.out.println("主题: " + MailUtil.getSubject(msg));
                    System.out.println("发件人: " + MailUtil.getFrom(msg));
                    System.out.println("收件人：" + MailUtil.getReceiveAddress(msg, null));
                    System.out.println("发送时间：" + MailUtil.getSentDate(msg, null));
                    System.out.println("邮件优先级：" + MailUtil.getPriority(msg));
                    System.out.println("是否需要回执：" + MailUtil.isReplySign(msg));
                    System.out.println("邮件大小：" + msg.getSize() * 1024 + "kb");
                    boolean isContainerAttachment = MailUtil.isContainAttachment(msg);
                    System.out.println("是否包含附件：" + isContainerAttachment);
                    if (isContainerAttachment) {
                        // TODO need change directory
                        MailUtil.saveAttachment(msg, "f:\\mailTest\\" + msg.getSubject() + "_" + i + "_"); //保存附件
                    }
                    StringBuffer content = new StringBuffer(30);
                    MailUtil.getMailTextContent(msg, content);
                    System.out.println("邮件正文：" + (content.length() > 100 ? content.substring(0, 100) + "..." : content));
                    System.out.println("------------------第" + msg.getMessageNumber() + "封邮件解析结束-------------------- ");
                    System.out.println();

                    // 往replied_email_log表里新增一条记录
                    RepliedEmailLog repliedEmailLog = new RepliedEmailLog();
                    repliedEmailLog.setEmailSubject(MailUtil.getSubject(msg));
                    repliedEmailLog.setEmailBody(content.toString());
                    repliedEmailLog.setAbsenceReason(extractAbsenceReason(content.toString()));
                    repliedEmailLog.setRepliedDate(msg.getSentDate());
                    repliedEmailLog.setRepliedEmailLogId(UUIDUtil.getUUID());
                    addRepliedEmailLog(repliedEmailLog);

                    // 更新email_log表
                    Student student = studentService.findStudentByEmail(MailUtil.getFromAddr(msg));
                    EmailLog emailLog = emailLogService.findEmailLogByEmailLogId(student.getEmailLogId());
                    emailLog.setRepliedEmailId(repliedEmailLog.getRepliedEmailLogId());
                    emailLog.setIsReplied("TRUE");
                    emailLogService.updateSelective(emailLog);
                    System.out.println("============================更新完成");
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
