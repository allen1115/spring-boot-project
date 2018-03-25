package com.example.demo.entity;

public class Student {
    private Long id;

    private String email;

    private String name;

    private String program;

    private String status;

    private Integer yearOfProgram;

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