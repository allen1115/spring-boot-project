package com.example.demo.entity;

import java.util.Date;

public class EmailLog {
    private Long id;

    private String repliedEmailId;

    private String isReplied;

    private Date createDate;

    private Date updateDate;

    private String emailLogId;

    private RepliedEmailLog repliedEmailLog;

    private String isSentAlert;

    public String getIsSentAlert() {
        return isSentAlert;
    }

    public void setIsSentAlert(String isSentAlert) {
        this.isSentAlert = isSentAlert;
    }

    public RepliedEmailLog getRepliedEmailLog() {
        return repliedEmailLog;
    }

    public void setRepliedEmailLog(RepliedEmailLog repliedEmailLog) {
        this.repliedEmailLog = repliedEmailLog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepliedEmailId() {
        return repliedEmailId;
    }

    public void setRepliedEmailId(String repliedEmailId) {
        this.repliedEmailId = repliedEmailId;
    }

    public String getIsReplied() {
        return isReplied;
    }

    public void setIsReplied(String isReplied) {
        this.isReplied = isReplied == null ? null : isReplied.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getEmailLogId() {
        return emailLogId;
    }

    public void setEmailLogId(String emailLogId) {
        this.emailLogId = emailLogId == null ? null : emailLogId.trim();
    }
}