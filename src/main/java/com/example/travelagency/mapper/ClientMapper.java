package com.example.travelagency.mapper;

import com.example.travelagency.controller.model.order.ClientResponse;
import com.example.travelagency.mapper.model.Client;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientMapper {

    void insertClient(@Param("client") Client client);

    Optional<ClientResponse> selectClient(@Param("id") Long id);

}

