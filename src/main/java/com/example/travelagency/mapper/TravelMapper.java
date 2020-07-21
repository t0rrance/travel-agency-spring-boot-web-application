package com.example.travelagency.mapper;

import com.example.travelagency.controller.model.travel.TravelResponse;
import com.example.travelagency.mapper.model.Travel;
import com.example.travelagency.mapper.model.TravelAccommodation;
import com.example.travelagency.mapper.model.TravelAdditionalItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TravelMapper {
    void insertTravel(@Param("travelRequest") Travel travel);

    Optional<TravelResponse> selectTravel(@Param("id") Long id);

    void updateTravel(@Param("travelRequest") Travel travel);

    void insertTravelAdditionalItem(@Param("item") TravelAdditionalItem item);

    void insertTravelAccommodation(@Param("travelAccommodation") TravelAccommodation travelAccommodation);

}
