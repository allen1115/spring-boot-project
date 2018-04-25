package com.example.demo.service;

import com.example.demo.entity.Role;

import java.util.List;

public interface RoleService {

    int addRole(Role role);

    List<Role> findAllRoles();

    int deleteRoleById(Integer id);

}
