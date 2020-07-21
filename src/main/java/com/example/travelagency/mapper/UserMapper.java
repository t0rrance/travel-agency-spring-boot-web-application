package com.example.travelagency.mapper;

import com.example.travelagency.controller.model.user.UserResponse;
import com.example.travelagency.mapper.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMapper {

    void insertUser(@Param("user") User user);

    Optional<UserResponse> selectUserByUserName(String userName);

}
