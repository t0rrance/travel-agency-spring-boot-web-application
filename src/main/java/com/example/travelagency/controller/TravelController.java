package com.example.travelagency.controller;

import com.example.travelagency.controller.model.travel.TravelRequest;
import com.example.travelagency.controller.model.travel.TravelResponse;
import com.example.travelagency.service.TravelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/admin/travels")
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity<List<TravelResponse>> getAll() {
        List<TravelResponse> travels = travelService.getTravels();
        return ResponseEntity.ok().body(travels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelResponse> get(@PathVariable Long id) {
        if (travelService.getTravel(id).isEmpty()) {
            return ResponseEntity.status(FORBIDDEN).build();
        }

        TravelResponse response = travelService.getTravel(id).orElseThrow();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TravelResponse> add(@RequestBody @Valid @NotNull TravelRequest travelRequest) {
        TravelResponse response = travelService.addTravel(travelRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TravelResponse> update(@PathVariable Long id,
                                                 @RequestBody @Valid @NotNull TravelRequest travelRequest) {
        if (travelService.getTravel(id).isEmpty()) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
        TravelResponse response = travelService.updateTravel(id, travelRequest);
        return ResponseEntity.ok(response);
    }

}
