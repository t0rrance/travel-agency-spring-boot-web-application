package com.example.travelagency.auth.controller.model.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    @ApiModelProperty("User name")
    private String userName;
    @ApiModelProperty("Imię")
    private String firstName;
    @ApiModelProperty("Nazwisko")
    private String lastName;
    @ApiModelProperty("Hasło")
    private String password;
    @ApiModelProperty("Rola")
    private String role;
    @ApiModelProperty("Token")
    private String token;
}
