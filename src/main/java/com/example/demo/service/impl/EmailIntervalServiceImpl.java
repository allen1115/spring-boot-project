package com.example.demo.service.impl;

import com.example.demo.dao.EmailIntervalMapper;
import com.example.demo.entity.EmailInterval;
import com.example.demo.service.EmailIntervalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailIntervalServiceImpl implements EmailIntervalService {

    @Autowired
    private EmailIntervalMapper emailIntervalMapper;

    @Override
    public EmailInterval getEmailInterval() {
        return emailIntervalMapper.selectByPrimaryKey(1L);
    }
}
