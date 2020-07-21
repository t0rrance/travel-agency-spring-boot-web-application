package com.example.travelagency.mapper.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TravelAdditionalItem {
    private Long travelId;
    private Long additionalItemId;
}
