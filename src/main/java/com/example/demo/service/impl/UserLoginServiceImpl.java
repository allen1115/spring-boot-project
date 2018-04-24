package com.example.demo.service.impl;

import com.example.demo.dao.UserLoginMapper;
import com.example.demo.entity.UserLogin;
import com.example.demo.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public UserLogin findUserByUsername(String username) {
        return userLoginMapper.findUserByUsername(username);
    }

    @Override
    public List<UserLogin> findAllUsers() {
        return userLoginMapper.selectAll();
    }
}
