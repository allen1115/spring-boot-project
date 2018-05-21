package com.example.demo.controller.rest;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.UserLogin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody JSONObject param, Map<String, Object> map, HttpSession session) {
        UsernamePasswordToken utoken = new UsernamePasswordToken(param.getString("username"), param.getString("password"));
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(utoken); // complete login
            UserLogin user = (UserLogin) subject.getPrincipal();
            session.setAttribute("user", user);
            // set session timeout
            subject.getSession().setTimeout(1800);
            session.setMaxInactiveInterval(1800);
            map.put("user", user);
            return "success";
        } catch (Exception e) {
            return "Invalid login, please try again!";
        }
    }
}
