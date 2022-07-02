package com.basketteamapi.basketteam.controllers;

import com.basketteamapi.basketteam.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@Data
@TestPropertySource("/application-test.properties")
public abstract class BaseControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    protected User mockUserAuth;

    @Autowired
    protected MockHelperService mockHelperService;

    protected void registerMockUserAuth(String username) {
        mockUserAuth = mockHelperService.createUser(username, "password");
    }
}
