package com.basketteamapi.basketteam.controllers;

import com.basketteamapi.basketteam.security.UserAuthToken;
import com.basketteamapi.basketteam.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest extends BaseControllerTest {

    @Autowired
    private UserController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    @WithMockUser(username = "testName")
    public void getUserName() throws Exception {
        registerMockUserAuth("testName");

        mockMvc.perform(get("/v1/users/user-name"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(getMockUserAuth().getUsername()));
    }

    @Test
    public void getUserNameUnauthorized() throws Exception {
        mockMvc.perform(get("/v1/users/user-name"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void register() throws Exception {
        User user = new User();
        user.setUsername("John");
        user.setPassword("Smith");

        UserAuthToken userAuthToken = new UserAuthToken(user.getUsername() + ":" + user.getPassword());

        mockMvc.perform(post("/v1/users/register")
                        .content(objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userAuthToken)));
    }
}