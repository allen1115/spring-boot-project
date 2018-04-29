package com.example.demo.service.impl;

import com.example.demo.dao.EmailTemplateMapper;
import com.example.demo.entity.EmailTemplate;
import com.example.demo.service.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailTemplateServiceImpl implements EmailTemplateService {

    @Autowired
    private EmailTemplateMapper emailTemplateMapper;

    @Override
    public EmailTemplate getEmailTemplateByLevel(String level) {
        return emailTemplateMapper.selectByLevel(level);
    }

    @Override
    public List<EmailTemplate> getAllEmailTemplates() {
        return emailTemplateMapper.selectAll();
    }
}
