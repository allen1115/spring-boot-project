package com.example.demo.entity;

import java.util.Date;

public class EmailLog {
    private Long id;

    private Long repliedEmailId;

    private String isReplied;

    private Date createDate;

    private Date updateDate;

    private String emailLogId;

    private RepliedEmailLog repliedEmailLog;

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

    public Long getRepliedEmailId() {
        return repliedEmailId;
    }

    public void setRepliedEmailId(Long repliedEmailId) {
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