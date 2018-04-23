package com.example.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UnauthorisedController {

    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public String login(){
        return "unauthorized_page";
    }
}
