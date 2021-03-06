package com.example.travelagency.mapper.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
    private Long id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String address;
}
