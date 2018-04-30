package com.example.demo.service.impl;

import com.example.demo.dao.EmailLogMapper;
import com.example.demo.entity.EmailLog;
import com.example.demo.service.EmailLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailLogServiceImpl implements EmailLogService {

    @Autowired
    private EmailLogMapper emailLogMapper;

    @Override
    public int insertSelective(EmailLog emailLog) {
        return emailLogMapper.insertSelective(emailLog);
    }

    @Override
    public EmailLog findEmailLogByEmailLogId(String emailLogId) {
        return emailLogMapper.findEmailLogByEmailLogId(emailLogId);
    }

    @Override
    public int updateSelective(EmailLog emailLog) {
        return emailLogMapper.updateByPrimaryKeySelective(emailLog);
    }

    @Override
    public List<EmailLog> findAll() {
        return emailLogMapper.selectAll();
    }
}
