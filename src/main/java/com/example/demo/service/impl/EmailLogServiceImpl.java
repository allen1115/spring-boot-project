package com.example.demo.service.impl;

import com.example.demo.dao.EmailLogMapper;
import com.example.demo.entity.EmailLog;
import com.example.demo.service.EmailLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailLogServiceImpl implements EmailLogService {

    @Autowired
    private EmailLogMapper emailLogMapper;

    @Override
    public int insertSelective(EmailLog emailLog) {
        return emailLogMapper.insertSelective(emailLog);
    }
}
