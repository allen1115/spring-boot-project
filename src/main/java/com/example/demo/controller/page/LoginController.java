package com.example.demo.controller.page;

import com.example.demo.entity.UserLogin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute UserLogin model, Map<String, Object> map, HttpSession session) {
        UsernamePasswordToken utoken = new UsernamePasswordToken(model.getUsername(), model.getPassword());
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(utoken); // 完成登陆
            UserLogin user = (UserLogin) subject.getPrincipal();
            session.setAttribute("user", user);
            map.put("user", user);
            return "/index";
        } catch (Exception e) {
            return "login";
        }
    }
}
