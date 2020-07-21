package com.example.travelagency.service;

import com.example.travelagency.controller.model.order.ClientRequest;
import com.example.travelagency.controller.model.order.ClientResponse;
import com.example.travelagency.mapper.ClientMapper;
import com.example.travelagency.mapper.model.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientMapper clientMapper;

    public ClientService(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    @Transactional
    public ClientResponse addClient(ClientRequest clientRequest) {
        Client client = createClient(clientRequest);
        clientMapper.insertClient(client);
        return clientMapper.selectClient(client.getId()).orElseThrow();
    }

    private Client createClient(ClientRequest clientRequest) {
        return createClient(null, clientRequest);
    }

    private Client createClient(Long clientId, ClientRequest clientRequest) {
        return Client.builder()
                .id(clientId)
                .firstName(clientRequest.getFirstName())
                .lastName(clientRequest.getLastName())
                .phoneNumber(clientRequest.getPhoneNumber())
                .address(clientRequest.getAddress())
                .build();
    }

}
