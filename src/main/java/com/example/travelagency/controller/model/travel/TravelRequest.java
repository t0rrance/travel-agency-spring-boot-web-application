package com.example.travelagency.controller.model.travel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TravelRequest {
    @ApiModelProperty("Nazwa wycieczki")
    private String travelName;
    @ApiModelProperty("Liczba miejsc")
    private int numberOfSeats;
    @ApiModelProperty("Cena jednostkowa za uczestnika")
    private int pricePerSeat;
    @ApiModelProperty("Data rozpoczęcia wycieczki")
    private Date startDate;
    @ApiModelProperty("Data zakończenia wycieczki")
    private Date finishDate;
    @ApiModelProperty("Lista możliwych do wybrania dodatków wycieczki")
    private List<AdditionalItem> itemsList;
    @ApiModelProperty("Lista możliwych noclegów do wybory")
    private List<Accommodation> accommodationList;
}
