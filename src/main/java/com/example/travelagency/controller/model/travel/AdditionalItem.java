package com.example.travelagency.controller.model.travel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AdditionalItem {
    @ApiModelProperty("Nazwa dodatku wycieczki")
    private String itemName;
    @ApiModelProperty("Cena dodatki za osobę")
    private int pricePerSeat;
}
