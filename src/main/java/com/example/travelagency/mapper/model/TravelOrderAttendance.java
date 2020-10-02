package com.example.travelagency.mapper.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TravelOrderAttendance {
    private Long travelOrderId;
    private Long clienttId;
}
