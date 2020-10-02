package com.example.travelagency.auth.service;

import com.example.travelagency.auth.mapper.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    Optional<User> findByUsername(String username);

    List<User> findAllUsers();

}
