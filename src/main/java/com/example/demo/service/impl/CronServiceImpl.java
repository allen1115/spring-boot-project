package com.example.demo.service.impl;

import com.example.demo.dao.CronMapper;
import com.example.demo.entity.Cron;
import com.example.demo.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CronServiceImpl implements CronService {

    @Autowired
    private CronMapper cronMapper;

    @Override
    public Cron getCronExpression(Long id) {
        return cronMapper.selectByPrimaryKey(id);
    }
}
