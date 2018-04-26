package com.example.demo.controller.rest;

import com.example.demo.entity.RepliedEmailLog;
import com.example.demo.service.impl.RepliedEmailLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/repliedEmail")
public class RepliedEmailController {

    @Autowired
    private RepliedEmailLogServiceImpl repliedEmailLogService;

    @RequestMapping(value = "/getAllRepliedEmails", method = RequestMethod.GET)
    public List<RepliedEmailLog> getAllRepliedEmails() {
        return repliedEmailLogService.findAllRepliedEmailsOrderByDate();
    }
}
