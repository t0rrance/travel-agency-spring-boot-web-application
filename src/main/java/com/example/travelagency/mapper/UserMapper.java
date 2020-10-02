package com.example.travelagency.mapper;

import com.example.travelagency.auth.mapper.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMapper {

    void insertUser(@Param("user") User user);

    Optional<User> selectUser(@Param("userName") String userName);

}
