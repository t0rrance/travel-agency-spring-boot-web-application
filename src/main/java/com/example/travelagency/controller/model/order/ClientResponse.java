package com.example.travelagency.controller.model.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClientResponse {
    @ApiModelProperty("Identyfikator klienta")
    private Long id;
    @ApiModelProperty("Imię klienta")
    private String firstName;
    @ApiModelProperty("Nazwisko klienta")
    private String lastName;
    @ApiModelProperty("Numer telefonu")
    private String phoneNumber;
    @ApiModelProperty("Adres zamieszkania")
    private String address;
}
