package com.example.demo.service;

import com.example.demo.entity.EmailTemplate;

public interface EmailTemplateService {
    EmailTemplate getEmailTemplateByLevel(String level);
}
