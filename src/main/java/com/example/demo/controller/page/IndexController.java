package com.example.demo.controller.page;

import com.example.demo.entity.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String index(HttpSession session) {
        UserLogin user = (UserLogin) session.getAttribute("user");
        if(user != null) {
            return "/index";
        }
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session){
        UserLogin user = (UserLogin) session.getAttribute("user");
        if(user != null) {
            return "/index";
        }
        return "login";
    }

    @RequestMapping("/index")
    public String home() {return "index";}

    @RequestMapping("/upload")
    public String upload() {return "upload";}

    @RequestMapping("/role")
    public String role() {return "roleM";}

    @RequestMapping("/admin")
    public String admin() {return "adminM";}
}
