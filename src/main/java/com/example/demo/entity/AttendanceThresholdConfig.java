package com.example.demo.entity;

public class AttendanceThresholdConfig {
    private Integer id;

    private Double firstLevel;

    private Double secondLevel;

    private Double thirdLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getFirstLevel() {
        return firstLevel;
    }

    public void setFirstLevel(Double firstLevel) {
        this.firstLevel = firstLevel;
    }

    public Double getSecondLevel() {
        return secondLevel;
    }

    public void setSecondLevel(Double secondLevel) {
        this.secondLevel = secondLevel;
    }

    public Double getThirdLevel() {
        return thirdLevel;
    }

    public void setThirdLevel(Double thirdLevel) {
        this.thirdLevel = thirdLevel;
    }
}