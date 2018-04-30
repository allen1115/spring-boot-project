package com.example.demo.controller.rest;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.AttendanceThresholdConfig;
import com.example.demo.entity.EmailInterval;
import com.example.demo.entity.EmailTemplate;
import com.example.demo.service.impl.AttendanceThresholdConfigServiceImpl;
import com.example.demo.service.impl.EmailIntervalServiceImpl;
import com.example.demo.service.impl.EmailTemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private EmailIntervalServiceImpl emailIntervalService;

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

    @RequestMapping(value = "/updateEmailTemplateByID", method = RequestMethod.POST)
    public int updateEmailTemplateByID(@RequestBody JSONObject param) {
        EmailTemplate emailTemplate = new EmailTemplate();
        emailTemplate.setId(param.getInteger("id"));
        emailTemplate.setTemplateName(param.getString("subject"));
        emailTemplate.setTemplateBody(param.getString("template"));
        return emailTemplateService.updateEmailTemplateByID(emailTemplate);
    }

    @RequestMapping(value = "/updateLvlOfAttendance", method = RequestMethod.POST)
    public int updateLvlOfAttendance(@RequestBody JSONObject param) {
        AttendanceThresholdConfig attendanceThresholdConfig = new AttendanceThresholdConfig();
        attendanceThresholdConfig.setFirstLevel(param.getDouble("first"));
        attendanceThresholdConfig.setSecondLevel(param.getDouble("second"));
        attendanceThresholdConfig.setThirdLevel(param.getDouble("third"));
        return attendanceThresholdConfigService.updateConfig(attendanceThresholdConfig);
    }

    @RequestMapping(value = "/getEmailInterval", method = RequestMethod.GET)
    public EmailInterval getEmailInterval() {
        return emailIntervalService.getEmailInterval();
    }

    @RequestMapping(value = "/updateEmailInterval", method = RequestMethod.POST)
    public int updateEmailInterval(@RequestBody JSONObject param) {
        EmailInterval emailInterval = new EmailInterval();
        emailInterval.setId(1L);
        emailInterval.setInterval(param.getInteger("time"));
        return emailIntervalService.updateEmailInterval(emailInterval);
    }
}
