package com.example.travelagency.service;

import com.example.travelagency.auth.service.UserService;
import com.example.travelagency.controller.model.order.ClientRequest;
import com.example.travelagency.controller.model.order.ClientResponse;
import com.example.travelagency.controller.model.order.TravelOrderRequest;
import com.example.travelagency.controller.model.order.TravelOrderResponse;
import com.example.travelagency.mapper.ClientMapper;
import com.example.travelagency.mapper.TravelOrderAttendanceMapper;
import com.example.travelagency.mapper.TravelOrderMapper;
import com.example.travelagency.mapper.model.TravelOrder;
import com.example.travelagency.mapper.model.TravelOrderAttendance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelOrderService {

    private final Long TEMPORARY_USER_TEST = 1L;
    private final TravelOrderMapper travelOrderMapper;
    private final ClientMapper clientMapper;
    private final ClientService clientService;
    private final UserService userService;
    private final TravelOrderAttendanceMapper travelOrderAttendanceMapper;
    public TravelOrderService(TravelOrderMapper travelOrderMapper, ClientMapper clientMapper, ClientService clientService, UserService userService, TravelOrderAttendanceMapper travelOrderAttendanceMapper) {
        this.travelOrderMapper = travelOrderMapper;
        this.clientMapper = clientMapper;
        this.clientService = clientService;
        this.userService = userService;
        this.travelOrderAttendanceMapper = travelOrderAttendanceMapper;
    }

    @Transactional
    public TravelOrderResponse addTravelOrder(TravelOrderRequest travelOrderRequest) {
        ClientResponse clientOrder = clientService.addClient(travelOrderRequest.getClientOrder());
        TravelOrder travelOrder = createTravelOrder(clientOrder.getId(), userService.findByUsername(travelOrderRequest.getUserName()).orElseThrow().getId(), travelOrderRequest);
        travelOrderMapper.insertTravelOrder(travelOrder);
        createClientAttendanceListTravel(travelOrder.getId(), travelOrderRequest.getAttendanceList());
        //test czy zapisuje klientów z attendance list i strzowyć zapis dal additionalOrderItemsList
        return null;
    }

    private void createClientAttendanceListTravel(Long idTravelOrder, List<ClientRequest> attendanceList) {
         var travelClientAttendanceList = createAttendanceClient(attendanceList);
         var travelOrderAttendanceList = createTravelOrderAttendanceObjects(idTravelOrder, travelClientAttendanceList);
         for(var item : travelOrderAttendanceList) {
             travelOrderAttendanceMapper.insertTravelOrderAttendance(item);
         }
    }

    private List<TravelOrderAttendance> createTravelOrderAttendanceObjects(Long idTravelOrder, List<ClientResponse> travelClientAttendanceList) {
        return travelClientAttendanceList.stream()
                .map(client -> createAttendanceObject(idTravelOrder, client))
                .collect(Collectors.toList());
    }

    private TravelOrderAttendance createAttendanceObject(Long idTravelOrder, ClientResponse client) {
        return TravelOrderAttendance.builder()
                .travelOrderId(idTravelOrder)
                .clienttId(client.getId())
                .build();
    }

    private List<ClientResponse> createAttendanceClient(List<ClientRequest> attendanceClientList) {
        return attendanceClientList.stream()
                .map(client -> clientService.addClient(client))
                .collect(Collectors.toList());
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
