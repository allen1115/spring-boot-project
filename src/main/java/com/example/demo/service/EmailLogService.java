package com.example.demo.service;

import com.example.demo.entity.EmailLog;

import java.util.List;

public interface EmailLogService {

    int insertSelective(EmailLog emailLog);

    EmailLog findEmailLogByEmailLogId(String emailLogId);

    int updateSelective(EmailLog emailLog);

    List<EmailLog> findAll();
}
