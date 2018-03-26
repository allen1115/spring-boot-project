package com.example.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserLogin {
    private Long id;

    private String username;

    private String password;

    private Date inactiveDate;

    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
    }
}