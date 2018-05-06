package com.example.demo.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomPermissionAutorizationFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) throws Exception {
        Subject subject = getSubject(req, resp);
        String[] permissionArray = (String[]) mappedValue;

        if (permissionArray == null || permissionArray.length == 0) {
            return true;
        }
        for (int i = 0; i < permissionArray.length; i++) {
            if (subject.isPermitted(permissionArray[i])) {
                return true;
            }
        }

        return false;
    }
}
