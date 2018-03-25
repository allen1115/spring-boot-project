package com.example.demo.service;

import com.example.demo.entity.UserLogin;

public interface UserLoginService {

    UserLogin findUserByUsername(String username);
}
