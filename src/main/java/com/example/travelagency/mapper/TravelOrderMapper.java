package com.example.travelagency.mapper;

import com.example.travelagency.mapper.model.TravelOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelOrderMapper {

    void insertTravelOrder(@Param("travelOrder") TravelOrder travelOrder);

}
