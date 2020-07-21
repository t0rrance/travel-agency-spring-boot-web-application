package com.example.travelagency.mapper;

import com.example.travelagency.mapper.model.TravelOrderAttendance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelOrderAttendanceMapper {

    void insertTravelOrderAttendance(@Param("travelOrderAttendance")TravelOrderAttendance travelOrderAttendance);

}
