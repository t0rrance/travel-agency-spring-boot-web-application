package com.example.travelagency.controller;

import com.example.travelagency.controller.model.order.ClientRequest;
import com.example.travelagency.controller.model.order.ClientResponse;
import com.example.travelagency.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponse> add(@RequestBody @NotNull @Valid ClientRequest clientRequest) {
        ClientResponse clientResponse = clientService.addClient(clientRequest);
        return ResponseEntity.ok(clientResponse);
    }

}
