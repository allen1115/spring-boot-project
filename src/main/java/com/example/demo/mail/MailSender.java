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
     * set title
     * @param title
     * @return
     */
    public MailSender title(String title) {
        mail.setTitle(title);
        return this;
    }

    /**
     * set content
     * @param content
     * @return
     */
    public MailSender content(String content) {
        mail.setContent(content);
        return this;
    }

    /**
     * set content type
     * @param typeEnum
     * @return
     */
    public MailSender contentType(MailContentTypeEnum typeEnum) {
        mail.setContentType(typeEnum.getValue());
        return this;
    }

    /**
     * set receiver
     * @param targets
     * @return
     */
    public MailSender targets(List<String> targets) {
        mail.setList(targets);
        return this;
    }

    /**
     * send email
     * @throws Exception
     */
    public void send() throws Exception {
        // default content type HTML
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

        // read resource/mail_zh_CN.properties
        final PropertiesUtil properties = new PropertiesUtil("mail");
        // create properties class to record some attributes of email
        final Properties props = new Properties();
        // authenticate for SMTP
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        // set SMTP server
        props.put("mail.smtp.host", properties.getValue("mail.smtp.service"));
        // set port number
        props.put("mail.smtp.port", properties.getValue("mail.smtp.port"));
        // set email address to send email
        props.put("mail.user", properties.getValue("mail.from.address"));
        // pwd
        props.put("mail.password", properties.getValue("mail.from.smtp.pwd"));
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // create session
        Session mailSession = Session.getInstance(props, authenticator);
        // create email message
        MimeMessage message = new MimeMessage(mailSession);
        // set email sender
        String nickName = MimeUtility.encodeText(properties.getValue("mail.from.nickname"));
        InternetAddress from = new InternetAddress(nickName + " <" + props.getProperty("mail.user") + ">");
        message.setFrom(from);

        // set title
        message.setSubject(mail.getTitle());

        // send email
        if(mail.getContentType().equals(MailContentTypeEnum.HTML.getValue())) {
            // set content
            message.setContent(mail.getContent(), mail.getContentType());
        }else {
            // send email by plain text
            message.setText(mail.getContent());
        }

        // receivers list
        List<String> targets = mail.getList();
        for (String target : targets) {
            try {
                // email address
                InternetAddress to = new InternetAddress(target);
                message.setRecipient(Message.RecipientType.TO, to);
                // send email
                Transport.send(message);
            } catch (Exception ignored) {
            }
        }
    }
}
