package com.example.demo.entity;

import java.util.Date;

public class RepliedEmailLog {
    private Long id;

    private String emailSubject;

    private String emailBody;

    private String absenceReason;

    private Date repliedDate;

    private String repliedEmailLogId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject == null ? null : emailSubject.trim();
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody == null ? null : emailBody.trim();
    }

    public String getAbsenceReason() {
        return absenceReason;
    }

    public void setAbsenceReason(String absenceReason) {
        this.absenceReason = absenceReason == null ? null : absenceReason.trim();
    }

    public Date getRepliedDate() {
        return repliedDate;
    }

    public void setRepliedDate(Date repliedDate) {
        this.repliedDate = repliedDate;
    }

    public String getRepliedEmailLogId() {
        return repliedEmailLogId;
    }

    public void setRepliedEmailLogId(String repliedEmailLogId) {
        this.repliedEmailLogId = repliedEmailLogId == null ? null : repliedEmailLogId.trim();
    }
}