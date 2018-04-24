package com.example.demo.service.impl;

import com.example.demo.dao.RoleMapper;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int addRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleMapper.selectAll();
    }

    @Override
    public int deleteRoleById(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }
}
