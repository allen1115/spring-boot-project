package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class MailTest {

    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("396881692@qq.com");
        message.setTo("396881692@qq.com");
        message.setSubject("主题: 测试邮件");
        message.setText("测试邮件内容");

        mailSender.send(message);
    }
}
