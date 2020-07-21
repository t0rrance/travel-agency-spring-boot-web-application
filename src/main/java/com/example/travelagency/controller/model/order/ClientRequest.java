package com.example.travelagency.controller.model.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClientRequest {
    @ApiModelProperty("Imię klienta")
    private String firstName;
    @ApiModelProperty("Nazwisko klienta")
    private String lastName;
    @ApiModelProperty("Numer telefonu")
    private String phoneNumber;
    @ApiModelProperty("Adres zamieszkania")
    private String address;
}
