package com.example.travelagency.mapper;

import com.example.travelagency.mapper.model.AdditionalItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdditionalItemMapper {

    void insertAdditionalItem(@Param("item") AdditionalItem item);

    Optional<AdditionalItem> selectAdditionalItem(@Param("id") Long id);

}
