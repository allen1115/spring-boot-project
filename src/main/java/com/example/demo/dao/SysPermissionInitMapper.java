package com.example.demo.dao;

import com.example.demo.entity.SysPermissionInit;

import java.util.List;

public interface SysPermissionInitMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysPermissionInit record);

    int insertSelective(SysPermissionInit record);

    SysPermissionInit selectByPrimaryKey(Long id);

    List<SysPermissionInit> selectAll();

    int updateByPrimaryKeySelective(SysPermissionInit record);

    int updateByPrimaryKey(SysPermissionInit record);
}