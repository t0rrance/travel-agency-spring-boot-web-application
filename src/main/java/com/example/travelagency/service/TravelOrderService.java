package com.example.travelagency.service;

import com.example.travelagency.controller.model.order.ClientResponse;
import com.example.travelagency.controller.model.order.TravelOrderRequest;
import com.example.travelagency.controller.model.order.TravelOrderResponse;
import com.example.travelagency.mapper.ClientMapper;
import com.example.travelagency.mapper.TravelOrderMapper;
import com.example.travelagency.mapper.model.Client;
import com.example.travelagency.mapper.model.TravelOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TravelOrderService {

    private final Long TEMPORARY_USER_TEST = 1L;
    private final TravelOrderMapper travelOrderMapper;
    private final ClientMapper clientMapper;
    private final ClientService clientService;

    public TravelOrderService(TravelOrderMapper travelOrderMapper, ClientMapper clientMapper, ClientService clientService) {
        this.travelOrderMapper = travelOrderMapper;
        this.clientMapper = clientMapper;
        this.clientService = clientService;
    }

    @Transactional
    public TravelOrderResponse addTravelOrder(TravelOrderRequest travelOrderRequest) {
        ClientResponse clientOrder = clientService.addClient(travelOrderRequest.getClientOrder());
        TravelOrder travelOrder = createTravelOrder(clientOrder.getId(), TEMPORARY_USER_TEST, travelOrderRequest);
        travelOrderMapper.insertTravelOrder(travelOrder);
        //todo create client order
        //todo create order
        //todo create client attendance travel
        //todo create TravelOrderAttendance intersection Table
        return null;
    }

    private TravelOrder createTravelOrder(Long clientId, Long userId, TravelOrderRequest travelOrderRequest) {
        return createTravelOrder(null, clientId, userId, travelOrderRequest);
    }

    private TravelOrder createTravelOrder(Long travelOrderId, Long clientId, Long userId, TravelOrderRequest travelOrderRequest) {
        return TravelOrder.builder()
                .id(travelOrderId)
                .travelId(travelOrderRequest.getTravelId())
                .clientId(clientId)
                .userId(userId)
                .numberOfSeats(travelOrderRequest.getNumberOfSeats())
                .orderDate(travelOrderRequest.getOrderDate())
                .paymentDate(travelOrderRequest.getPaymentDate())
                .build();
    }

}
