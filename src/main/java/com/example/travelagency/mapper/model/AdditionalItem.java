package com.example.travelagency.mapper.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdditionalItem {
    private Long id;
    private String itemName;
    private int pricePerSeat;
}
