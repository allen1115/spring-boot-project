package com.example.demo.entity;

public class Cron {
    private Long cronId;

    private String cron;

    public Long getCronId() {
        return cronId;
    }

    public void setCronId(Long cronId) {
        this.cronId = cronId;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }
}