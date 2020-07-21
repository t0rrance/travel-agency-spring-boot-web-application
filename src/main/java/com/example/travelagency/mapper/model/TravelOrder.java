package com.example.travelagency.mapper.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TravelOrder {
    private Long id;
    private Long travelId;
    private Long clientId;
    private Long userId;
    private int numberOfSeats;
    private Date orderDate;
    private Date paymentDate;
}
