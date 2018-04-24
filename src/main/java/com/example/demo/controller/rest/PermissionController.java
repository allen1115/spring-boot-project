package com.example.demo.controller.rest;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Module;
import com.example.demo.entity.Role;
import com.example.demo.entity.UserLogin;
import com.example.demo.service.impl.ModuleServiceImpl;
import com.example.demo.service.impl.RoleServiceImpl;
import com.example.demo.service.impl.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private UserLoginServiceImpl userLoginService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private ModuleServiceImpl moduleService;

    /**
     * 获取所有的role
     * @return
     */
    @RequestMapping(value = "/getAllRoles", method = RequestMethod.GET)
    public List<Role> getAllRoles() {
        return roleService.findAllRoles();
    }

    /**
     * 获取所有的module (权限)
     */
    @RequestMapping(value = "/getAllModules", method = RequestMethod.GET)
    public List<Module> getAllModules() {
        return moduleService.findAllModules();
    }

    /**
     * 获取所有的user
     */
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<UserLogin> getAllUsers() {
        return userLoginService.findAllUsers();
    }

    /**
     * 新增role
     */
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public int addRole(@RequestBody JSONObject param) {
        String role = param.getString("role");
        // TODO add role
        System.out.println(role);
        return 1;
    }
}
