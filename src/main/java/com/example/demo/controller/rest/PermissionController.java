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
     * get all roles
     * @return
     */
    @RequestMapping(value = "/getAllRoles", method = RequestMethod.GET)
    public List<Role> getAllRoles() {
        return roleService.findAllRoles();
    }

    /**
     * get all modules
     */
    @RequestMapping(value = "/getAllModules", method = RequestMethod.GET)
    public List<Module> getAllModules() {
        return moduleService.findAllModulesForConfig();
    }

    /**
     * get all users
     */
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<UserLogin> getAllUsers() {
        return userLoginService.findAllUsers();
    }

    /**
     * add role
     */
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public int addRole(@RequestBody JSONObject param) {
        Role role = new Role();
        role.setRname(param.getString("role"));
        return roleService.addRole(role);
    }

    /**
     * add module
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
     * assign role to specific user
     */
    @RequestMapping(value = "/assignUserRole", method = RequestMethod.POST)
    public int assignUserRole(@RequestBody JSONObject param) {
        Long uid = param.getLong("uid");
        Long rid = param.getLong("rid");
        // check user role first
        int num = roleService.assignRoleToUser(rid, uid);
        if(num == 0) {
            return roleService.addRoleToUser(rid, uid);
        } else {
            return num;
        }
    }

    /**
     * assign module to specific role
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

    /**
     * Delete specific Role
     */
    @RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
    public int deleteRole(@RequestBody JSONObject param) {
        // delete role_module first
        Integer rid = param.getInteger("rid");
        roleService.deleteRoleModule(rid);
        return roleService.deleteRoleById(rid);
    }
}
