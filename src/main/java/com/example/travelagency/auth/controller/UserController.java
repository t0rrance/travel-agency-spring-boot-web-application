package com.example.travelagency.auth.controller;

import com.example.travelagency.auth.controller.model.user.UserRequest;
import com.example.travelagency.auth.controller.model.user.UserResponse;
import com.example.travelagency.auth.jwt.JwtTokenProvider;
import com.example.travelagency.auth.mapper.model.User;
import com.example.travelagency.auth.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    public UserController(JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/api/user/registration")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUserName()).isEmpty()) {
            user.setRole("USER");
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping("/api/user/login")
    public ResponseEntity<?> login(Principal principal) {
        if (principal == null) {
            return ResponseEntity.ok(principal);
        }
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
        User user = userService.findByUsername(authenticationToken.getName()).orElseThrow();
        user.setToken(jwtTokenProvider.generateToken(authenticationToken));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}

