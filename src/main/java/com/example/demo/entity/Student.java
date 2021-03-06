package com.example.demo.entity;

public class Student {
    private Long id;

    private String email;

    private String name;

    private String program;

    private String status;

    private Integer yearOfProgram;

    private Double avgAttendance;

    private String emailLogId;

    private String flag;

    private String tier_4;

    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTier_4() {
        return tier_4;
    }

    public void setTier_4(String tier_4) {
        this.tier_4 = tier_4;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private EmailLog emailLog;

    public String getEmailLogId() {
        return emailLogId;
    }

    public void setEmailLogId(String emailLogId) {
        this.emailLogId = emailLogId;
    }

    public EmailLog getEmailLog() {
        return emailLog;
    }

    public void setEmailLog(EmailLog emailLog) {
        this.emailLog = emailLog;
    }

    public Double getAvgAttendance() {
        return avgAttendance;
    }

    public void setAvgAttendance(Double avgAttendance) {
        this.avgAttendance = avgAttendance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program == null ? null : program.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getYearOfProgram() {
        return yearOfProgram;
    }

    public void setYearOfProgram(Integer yearOfProgram) {
        this.yearOfProgram = yearOfProgram;
    }
}