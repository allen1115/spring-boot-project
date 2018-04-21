package com.example.demo.service.impl;

import com.example.demo.dao.RepliedEmailLogMapper;
import com.example.demo.entity.RepliedEmailLog;
import com.example.demo.service.RepliedEmailLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepliedEmailLogServiceImpl implements RepliedEmailLogService {

    @Autowired
    private RepliedEmailLogMapper repliedEmailLogMapper;

    @Override
    public int insertSelective(RepliedEmailLog repliedEmailLog) {
        return repliedEmailLogMapper.insertSelective(repliedEmailLog);
    }
}
