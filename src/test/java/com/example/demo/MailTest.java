package com.example.demo;

import com.example.demo.mail.MailContentTypeEnum;
import com.example.demo.mail.MailSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class MailTest {

    @Autowired

    @Test
    public void sendSimpleMail() throws Exception {
        new MailSender()
                .title("Test Email")
                .content("Simple Text Content")
                .contentType(MailContentTypeEnum.TEXT)
                .targets(new ArrayList<String>(){{add("396881692@qq.com");}})
                .send();
    }
}
