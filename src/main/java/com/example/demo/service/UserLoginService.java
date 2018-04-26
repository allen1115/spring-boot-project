package com.example.demo.service;

import com.example.demo.entity.UserLogin;

import java.util.List;

public interface UserLoginService {

    UserLogin findUserByUsername(String username);

    List<UserLogin> findAllUsers();

}
