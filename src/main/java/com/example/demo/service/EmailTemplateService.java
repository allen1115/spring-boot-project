package com.example.demo.service;

import com.example.demo.entity.EmailTemplate;

import java.util.List;

public interface EmailTemplateService {
    EmailTemplate getEmailTemplateByLevel(String level);

    List<EmailTemplate> getAllEmailTemplates();
}
