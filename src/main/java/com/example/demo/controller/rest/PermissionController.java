package com.example.demo.controller.rest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Module;
import com.example.demo.entity.Role;
import com.example.demo.entity.UserLogin;
import com.example.demo.service.impl.ModuleServiceImpl;
import com.example.demo.service.impl.RoleServiceImpl;
import com.example.demo.service.impl.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        Role role = new Role();
        role.setRname(param.getString("role"));
        return roleService.addRole(role);
    }

    /**
     * 新增权限
     */
    @RequestMapping(value = "/addModule", method = RequestMethod.POST)
    public int addModule(@RequestBody JSONObject param) {
        Module module = new Module();
        module.setMname(param.getString("moduleName"));
        module.setUrl(param.getString("url"));
        module.setPermissionInit("authc,roles[" + param.getString("permission") + "]");
        return moduleService.addModule(module);
    }

    /**
     * 给用户assign角色
     */
    @RequestMapping(value = "/assignUserRole", method = RequestMethod.POST)
    public int assignUserRole(@RequestBody JSONObject param) {
        Long uid = param.getLong("uid");
        Long rid = param.getLong("rid");
        JSONArray test = param.getJSONArray("test");
        return roleService.assignRoleToUser(rid, uid);
    }

    /**
     * 给角色新增权限(Module)
     */
    @RequestMapping(value = "/assignRoleModule", method = RequestMethod.POST)
    public int assignRoleModule(@RequestBody JSONObject param) {
        Long rid = param.getLong("rid");
        JSONArray permissionArray = param.getJSONArray("permissions");
        int total = 0;
        for (Object aTest : permissionArray) {
            JSONObject permission = (JSONObject) aTest;
            Long pid = permission.getLong("pid");
            int i = roleService.assignRoleModule(rid, pid);
            total += i;
        }
        return total;
    }
}
