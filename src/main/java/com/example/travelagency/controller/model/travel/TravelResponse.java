package com.example.travelagency.controller.model.travel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class TravelResponse {
    @ApiModelProperty("Identyfikator wycieczki")
    private Long id;
    @ApiModelProperty("Nazwa wycieczki")
    private String travelName;
    @ApiModelProperty("Liczba miejsc")
    private int numberOfSeats;
    @ApiModelProperty("Liczba wykupionych miejsc")
    private int numberOccupiedSeats;
    @ApiModelProperty("Cena jednostkowa za uczestnika")
    private int pricePerSeat;
    @ApiModelProperty("Data rozpoczęcia wycieczki")
    private Date startDate;
    @ApiModelProperty("Data zakończenia wycieczki")
    private Date finishDate;
    @ApiModelProperty("Lista możliwych do wybrania dodatków wycieczki")
    private List<AdditionalItem> itemsList;
    @ApiModelProperty("Lista możłiwych do wyboru miejsc zakwaterowania")
    private List<Accommodation> accommodationList;
}
