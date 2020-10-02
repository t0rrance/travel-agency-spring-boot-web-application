package com.example.travelagency.auth.mapper.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String role;
    private String token;
}
