package com.example.demo.mail;

import com.example.demo.entity.MailEntity;
import com.example.demo.util.PropertiesUtil;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.List;
import java.util.Properties;

public class MailSender {
    // Mail entity
    private static MailEntity mail = new MailEntity();

    /**
     * 设置邮件标题
     * @param title
     * @return
     */
    public MailSender title(String title) {
        mail.setTitle(title);
        return this;
    }

    /**
     * 设置邮件内容
     * @param content
     * @return
     */
    public MailSender content(String content) {
        mail.setContent(content);
        return this;
    }

    /**
     * 设置邮件格式
     * @param typeEnum
     * @return
     */
    public MailSender contentType(MailContentTypeEnum typeEnum) {
        mail.setContentType(typeEnum.getValue());
        return this;
    }

    /**
     * 设置收件人
     * @param targets
     * @return
     */
    public MailSender targets(List<String> targets) {
        mail.setList(targets);
        return this;
    }

    /**
     * 执行发送邮件
     * @throws Exception
     */
    public void send() throws Exception {
        // 默认使用HTML发送
        if(mail.getContentType() == null) {
            mail.setContentType(MailContentTypeEnum.HTML.getValue());
        }
        if(mail.getTitle() == null || mail.getTitle().trim().length() == 0) {
            throw new Exception("No Email title set");
        }
        if(mail.getContent() == null || mail.getContent().trim().length() == 0) {
            throw new Exception("No Email content set");
        }
        if(mail.getList().size() == 0) {
            throw new Exception("No Email Receiver");
        }

        // 读取resource/mail_zh_CN.properties文件内容
        final PropertiesUtil properties = new PropertiesUtil("mail");
        // 创建properties类用于记录邮箱的一些属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件, 必须进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        // 此处填写SMTP服务器
        props.put("mail.smtp.host", properties.getValue("mail.smtp.service"));
        // 设置端口号
        props.put("mail.smtp.port", properties.getValue("mail.smtp.port"));
        // 设置发送邮箱
        props.put("mail.user", properties.getValue("mail.from.address"));
        // 设置发送邮箱的16位SMTP口令
        props.put("mail.password", properties.getValue("mail.from.smtp.pwd"));
        // 构建授权信息, 用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名, 密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息, 创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        String nickName = MimeUtility.encodeText(properties.getValue("mail.from.nickname"));
        InternetAddress from = new InternetAddress(nickName + " <" + props.getProperty("mail.user") + ">");
        message.setFrom(from);

        // 设置邮件标题
        message.setSubject(mail.getTitle());

        // html发送邮件
        if(mail.getContentType().equals(MailContentTypeEnum.HTML.getValue())) {
            // 设置邮件的内容体
            message.setContent(mail.getContent(), mail.getContentType());
        }else {
            // 使用文本发送邮件
            message.setText(mail.getContent());
        }

        // 收件人地址
        List<String> targets = mail.getList();
        for (String target : targets) {
            try {
                // 设置收件人的邮箱
                InternetAddress to = new InternetAddress(target);
                message.setRecipient(Message.RecipientType.TO, to);
                // 发送邮件
                Transport.send(message);
            } catch (Exception e) {
                continue;
            }
        }
    }
}
