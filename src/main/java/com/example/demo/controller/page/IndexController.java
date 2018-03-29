package com.example.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String index() {
        return "/login";
    }

    @RequestMapping("/login")
    public String login(){
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
