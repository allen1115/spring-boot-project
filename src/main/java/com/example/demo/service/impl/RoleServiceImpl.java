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
        return roleMapper.insertSelective(role);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleMapper.selectAll();
    }

    @Override
    public int deleteRoleById(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int assignRoleToUser(Long rid, Long uid) {
        return roleMapper.assignRoleToUser(rid, uid);
    }

    @Override
    public int addRoleToUser(Long rid, Long uid) {
        return roleMapper.addRoleToUser(rid, uid);
    }

    @Override
    public int deleteRoleModule(Integer rid) {
        return roleMapper.deleteRoleModule(rid);
    }

    @Override
    public int assignRoleModule(Long rid, Long pid) {
        return roleMapper.assignRoleModule(rid, pid);
    }
}
