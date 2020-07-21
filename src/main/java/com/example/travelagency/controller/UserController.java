package com.example.travelagency.controller;

import com.example.travelagency.controller.model.user.UserResponse;
import com.example.travelagency.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserResponse> getUser(String userName) {
        UserResponse userResponse = userService.getUser(userName);
        return ResponseEntity.ok().body(userResponse);
    }

}
