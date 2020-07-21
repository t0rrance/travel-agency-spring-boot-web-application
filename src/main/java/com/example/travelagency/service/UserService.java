package com.example.travelagency.service;

import com.example.travelagency.controller.model.user.UserResponse;
import com.example.travelagency.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    public UserResponse getUser(String userName) {
        return userMapper.selectUserByUserName(userName).orElseThrow();
    }

}
