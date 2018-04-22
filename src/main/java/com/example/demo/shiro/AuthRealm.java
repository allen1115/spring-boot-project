package com.example.demo.shiro;

import com.example.demo.entity.Module;
import com.example.demo.entity.Role;
import com.example.demo.entity.UserLogin;
import com.example.demo.service.UserLoginService;
import com.example.demo.service.impl.SysPermissionInitServiceImpl;
import com.example.demo.service.impl.UserLoginServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserLoginServiceImpl userLoginService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取Session中的用户
        UserLogin user = (UserLogin) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        // 获取用户的角色和权限
        List<String> permissions = new ArrayList<>();
        List<String> roleList = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        if(roles.size() > 0) {
            for (Role role : roles) {
                roleList.add(role.getRname());
                Set<Module> modules = role.getModules();
                if(modules.size() > 0) {
                    for (Module module : modules) {
                        permissions.add(module.getMname());
                    }
                }
            }
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleList);
        info.addStringPermissions(permissions);
        return info;
    }


    // 认证, 登陆
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户输入的token
        UsernamePasswordToken utoken = (UsernamePasswordToken) authenticationToken;
        String username = utoken.getUsername();
        UserLogin user = userLoginService.findUserByUsername(username);
        // 放入shiro, 调用credentialsMatcher校验密码
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}
