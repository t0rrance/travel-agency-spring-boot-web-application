package com.example.travelagency.controller.model.travel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Accommodation {
    @ApiModelProperty("Rodzaj zakwaterowania hotel/pensjonat itd.")
    private String typeAccommodation;
    @ApiModelProperty("Adres miejca zakwaterowania")
    private String address;
    @ApiModelProperty("Cena za dobę")
    private int pricePerDay;
}
