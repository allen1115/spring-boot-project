package com.example.demo.controller.rest;

import com.example.demo.entity.AttendanceThresholdConfig;
import com.example.demo.entity.EmailTemplate;
import com.example.demo.service.impl.AttendanceThresholdConfigServiceImpl;
import com.example.demo.service.impl.EmailTemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AttendanceThresholdConfigServiceImpl attendanceThresholdConfigService;

    @Autowired
    private EmailTemplateServiceImpl emailTemplateService;

    @RequestMapping(value = "/getThresholdConfig", method = RequestMethod.GET)
    public List<Double> getThresholdConfig() {
        AttendanceThresholdConfig config = attendanceThresholdConfigService.getAllConfig();
        List<Double> list = new ArrayList<>();
        list.add(config.getFirstLevel());
        list.add(config.getSecondLevel());
        list.add(config.getThirdLevel());
        return list;
    }

    @RequestMapping(value = "/getAllEmailTemplate", method = RequestMethod.GET)
    public List<EmailTemplate> getAllEmailTemplates() {
        return emailTemplateService.getAllEmailTemplates();
    }
}
