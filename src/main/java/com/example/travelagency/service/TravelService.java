package com.example.travelagency.service;

import com.example.travelagency.controller.model.travel.Accommodation;
import com.example.travelagency.controller.model.travel.AdditionalItem;
import com.example.travelagency.controller.model.travel.TravelRequest;
import com.example.travelagency.controller.model.travel.TravelResponse;
import com.example.travelagency.mapper.AccommodationMapper;
import com.example.travelagency.mapper.AdditionalItemMapper;
import com.example.travelagency.mapper.TravelMapper;
import com.example.travelagency.mapper.model.Travel;
import com.example.travelagency.mapper.model.TravelAccommodation;
import com.example.travelagency.mapper.model.TravelAdditionalItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TravelService {

    private final int DEFAULT_OCCUPIED_SEATS = 0;
    private final TravelMapper travelMapper;
    private final AdditionalItemMapper additionalItemMapper;
    private final AccommodationMapper accommodationMapper;

    public TravelService(TravelMapper travelMapper, AdditionalItemMapper additionalItemMapper, AccommodationMapper accommodationMapper) {
        this.travelMapper = travelMapper;
        this.additionalItemMapper = additionalItemMapper;
        this.accommodationMapper = accommodationMapper;
    }

    @Transactional
    public TravelResponse addTravel(TravelRequest travelRequest) {
        Travel travel = createTravel(travelRequest);
        travelMapper.insertTravel(travel);
        createTravelAdditionalItems(travel.getId(), travelRequest.getItemsList());
        createTravelAccommodations(travel.getId(), travelRequest.getAccommodationList());
        return travelMapper.selectTravel(travel.getId()).orElseThrow();
    }

    private void createTravelAccommodations(Long travelId, List<Accommodation> accommodationList) {
        var listAccommodation = createAccommodationObjects(accommodationList);
        for (var accommodation : listAccommodation) {
            this.accommodationMapper.insertAccommodation(accommodation);
        }
        var listTravelAccommodation = createTravelAccommodationObjects(travelId, listAccommodation);
        for(var accommodation : listTravelAccommodation) {
            travelMapper.insertTravelAccommodation(accommodation);
        }
    }

    private List<TravelAccommodation> createTravelAccommodationObjects(Long travelId, List<com.example.travelagency.mapper.model.Accommodation> listAccommodation) {
        return listAccommodation.stream()
                .map(accommodation -> createTravelAccommodation(travelId, accommodation))
                .collect(Collectors.toList());
    }

    private TravelAccommodation createTravelAccommodation(Long travelId,com.example.travelagency.mapper.model.Accommodation accommodation) {
        return TravelAccommodation.builder()
                .travelId(travelId)
                .accommodationId(accommodation.getId())
                .build();
    }

    private List<com.example.travelagency.mapper.model.Accommodation> createAccommodationObjects(List<Accommodation> accommodationList) {
        return accommodationList.stream()
                .map(accommodation -> createAccommodation(accommodation))
                .collect(Collectors.toList());
    }

    private com.example.travelagency.mapper.model.Accommodation createAccommodation(Accommodation accommodation) {
        return createAccommodation(null, accommodation);
    }

    private com.example.travelagency.mapper.model.Accommodation createAccommodation(Long id, Accommodation accommodation) {
        return com.example.travelagency.mapper.model.Accommodation.builder()
                .id(id)
                .typeAccommodation(accommodation.getTypeAccommodation())
                .address(accommodation.getAddress())
                .pricePerDay(accommodation.getPricePerDay())
                .build();
    }

    private void createTravelAdditionalItems(Long travelId, List<AdditionalItem> additionalItemsList) {
        var listAdditionalItem = createAdditionalItemsObjects(additionalItemsList);
        for (var item : listAdditionalItem) {
            additionalItemMapper.insertAdditionalItem(item);
        }
        var listTravelAdditionalItem = createTravelAdditionalItemsObjects(travelId, listAdditionalItem);
        for (var item : listTravelAdditionalItem) {
            travelMapper.insertTravelAdditionalItem(item);
        }
    }

    private List<com.example.travelagency.mapper.model.TravelAdditionalItem> createTravelAdditionalItemsObjects(Long travelId, List<com.example.travelagency.mapper.model.AdditionalItem> listAdditionalItem) {
        return listAdditionalItem.stream()
                .map(item -> createTravelItem(travelId, item))
                .collect(Collectors.toList());
    }

    private TravelAdditionalItem createTravelItem(Long travelId, com.example.travelagency.mapper.model.AdditionalItem item) {
        return TravelAdditionalItem.builder()
                .travelId(travelId)
                .additionalItemId(item.getId())
                .build();
    }


    private List<com.example.travelagency.mapper.model.AdditionalItem> createAdditionalItemsObjects(List<AdditionalItem> additionalItemsList) {
        return additionalItemsList.stream()
                .map(item -> createObjectItem(item))
                .collect(Collectors.toList());
    }

    private com.example.travelagency.mapper.model.AdditionalItem createObjectItem(AdditionalItem item) {
        return createObjectItem(null, item);
    }

    private com.example.travelagency.mapper.model.AdditionalItem createObjectItem(Long id, AdditionalItem item) {
        return com.example.travelagency.mapper.model.AdditionalItem.builder()
                .id(id)
                .itemName(item.getItemName())
                .pricePerSeat(item.getPricePerSeat())
                .build();
    }

    private Travel createTravel(TravelRequest travelRequest) {
        return createTravel(null, travelRequest);
    }

    private Travel createTravel(Long id, TravelRequest travelRequest) {
        return Travel.builder()
                .id(id)
                .travelName(travelRequest.getTravelName())
                .numberOfSeats(travelRequest.getNumberOfSeats())
                .numberOccupiedSeats(DEFAULT_OCCUPIED_SEATS)
                .pricePerSeat(travelRequest.getPricePerSeat())
                .startDate(travelRequest.getStartDate())
                .finishDate(travelRequest.getFinishDate())
                .build();
    }

    @Transactional(readOnly = true)
    public Optional<TravelResponse> getTravel(Long id) {
        return travelMapper.selectTravel(id);
    }

    @Transactional
    public TravelResponse updateTravel(Long id, TravelRequest travelRequest) {
        Travel travel = createTravel(id, travelRequest);
        travelMapper.updateTravel(travel);
        return travelMapper.selectTravel(id).orElseThrow();
    }

}
