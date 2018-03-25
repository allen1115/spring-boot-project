package com.example.demo.controller.page;

import com.example.demo.entity.UserLogin;
import com.example.demo.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute UserLogin model, HttpSession session) {

        UserLogin user = userLoginService.findUserByUsername(model.getUsername());

        if(user == null || !user.getPassword().equals(model.getPassword())) {
            return "login";
        } else {
            session.setAttribute("user", user);
            return "index";
        }
    }
}
