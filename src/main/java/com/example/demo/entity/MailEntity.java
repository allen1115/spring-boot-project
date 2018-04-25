package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Java Entity
 */
public class MailEntity implements Serializable {

    // SMTP server
    private String smtpService;

    // port
    private String smtpPort;

    // mail sender address
    private String fromMailAddress;

    // mail sender password
    private String fromMailSmtpPwd;

    // mail subject
    private String title;

    // mail content
    private String content;

    // content type (default HTML)
    private String contentType;

    // mail receiver address list
    private List<String> list = new ArrayList<>();

    public MailEntity() {
    }

    @Override
    public String toString() {
        return "MailEntity{" +
                "smtpService='" + smtpService + '\'' +
                ", smtpPort='" + smtpPort + '\'' +
                ", fromMailAddress='" + fromMailAddress + '\'' +
                ", fromMailSmtpPwd='" + fromMailSmtpPwd + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", contentType='" + contentType + '\'' +
                ", list=" + list +
                '}';
    }

    public String getSmtpService() {
        return smtpService;
    }

    public void setSmtpService(String smtpService) {
        this.smtpService = smtpService;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getFromMailAddress() {
        return fromMailAddress;
    }

    public void setFromMailAddress(String fromMailAddress) {
        this.fromMailAddress = fromMailAddress;
    }

    public String getFromMailSmtpPwd() {
        return fromMailSmtpPwd;
    }

    public void setFromMailSmtpPwd(String fromMailSmtpPwd) {
        this.fromMailSmtpPwd = fromMailSmtpPwd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public MailEntity(String smtpService, String smtpPort, String fromMailAddress, String fromMailSmtpPwd, String title, String content, String contentType, List<String> list) {
        this.smtpService = smtpService;
        this.smtpPort = smtpPort;
        this.fromMailAddress = fromMailAddress;
        this.fromMailSmtpPwd = fromMailSmtpPwd;
        this.title = title;
        this.content = content;
        this.contentType = contentType;
        this.list = list;
    }
}
