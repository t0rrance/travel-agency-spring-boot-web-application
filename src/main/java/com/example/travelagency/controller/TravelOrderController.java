package com.example.travelagency.controller;

import com.example.travelagency.controller.model.order.TravelOrderRequest;
import com.example.travelagency.controller.model.order.TravelOrderResponse;
import com.example.travelagency.service.TravelOrderService;
import com.example.travelagency.service.TravelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@RestController
@RequestMapping("/orders")
public class TravelOrderController {

    private final TravelOrderService travelOrderService;
    private final TravelService travelService;

    public TravelOrderController(TravelOrderService travelOrderService, TravelService travelService) {
        this.travelOrderService = travelOrderService;
        this.travelService = travelService;
    }

    @PostMapping
    public ResponseEntity<TravelOrderResponse> add(@RequestBody @NotNull @Valid TravelOrderRequest travelOrderRequest) {
        if (travelService.getTravel(travelOrderRequest.getTravelId()).isEmpty()) {
            return ResponseEntity.status(FORBIDDEN).build();
        }
        TravelOrderResponse response = travelOrderService.addTravelOrder(travelOrderRequest);
        return ResponseEntity.ok(response);
    }

}
