package com.example.travelagency.mapper.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Travel {
    private Long id;
    private String travelName;
    private int numberOfSeats;
    private int numberOccupiedSeats;
    private int pricePerSeat;
    private Date startDate;
    private Date finishDate;
}
