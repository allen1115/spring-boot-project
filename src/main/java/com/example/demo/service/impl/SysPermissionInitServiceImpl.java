package com.example.demo.service.impl;

import com.example.demo.dao.SysPermissionInitMapper;
import com.example.demo.entity.SysPermissionInit;
import com.example.demo.service.SysPermissionInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionInitServiceImpl implements SysPermissionInitService {

    @Autowired
    private SysPermissionInitMapper sysPermissionInitMapper;

    @Override
    public List<SysPermissionInit> selectAll() {
        return sysPermissionInitMapper.selectAll();
    }
}
