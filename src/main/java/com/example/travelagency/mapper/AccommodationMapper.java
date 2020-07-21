package com.example.travelagency.mapper;

import com.example.travelagency.mapper.model.Accommodation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccommodationMapper {

    void insertAccommodation(@Param("accommodation") Accommodation accommodation);

    Optional<Accommodation> selectAccommodation(@Param("accommodation") Accommodation accommodation);

}
