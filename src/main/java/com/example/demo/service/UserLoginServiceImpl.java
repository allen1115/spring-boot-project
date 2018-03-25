package com.example.demo.service;

import com.example.demo.dao.UserLoginMapper;
import com.example.demo.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public UserLogin findUserByUsername(String username) {
        return userLoginMapper.findUserByUsername(username);
    }
}
