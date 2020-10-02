package com.example.travelagency.auth.service;

import com.example.travelagency.controller.model.travel.TravelResponse;
import com.example.travelagency.mapper.UserMapper;
import com.example.travelagency.auth.mapper.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        User user = createUser(userRequest);
        userMapper.insertUser(user);
        return userMapper.selectUser(user.getUserName()).orElseThrow();
    }

    private User createUser(User userRequest) {
        return User.builder()
                .userName(userRequest.getUserName())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .password(userRequest.getPassword())
                .role(userRequest.getRole())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        return userMapper.selectUser(username);
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

}
