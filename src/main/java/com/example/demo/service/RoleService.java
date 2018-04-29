package com.example.demo.service;

import com.example.demo.entity.Role;

import java.util.List;

public interface RoleService {

    int addRole(Role role);

    List<Role> findAllRoles();

    int deleteRoleById(Integer id);

    int assignRoleToUser(Long rid, Long uid);

    int addRoleToUser(Long rid, Long uid);

    int deleteRoleModule(Integer rid);

    int assignRoleModule(Long rid, Long pid);
}
