package com.example.travelagency.controller;

import com.example.travelagency.controller.model.user.UserResponse;
import com.example.travelagency.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({UserController.class})
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    void testRespondWithOkOnGetUser() throws Exception {
        //given
        UserResponse userResponse = new UserResponse();
        when(userService.getUser(any())).thenReturn(userResponse);

        //when then
        mvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"userName\":null,\"firstName\":null,\"lastName\":null}"));
    }
}
