package com.example.demo.service;

import com.example.demo.entity.RepliedEmailLog;

import java.util.List;

public interface RepliedEmailLogService {

    int insertSelective(RepliedEmailLog repliedEmailLog);

    List<RepliedEmailLog> findAllRepliedEmailsOrderByDate();
}
