package com.basketteamapi.basketteam.controllers;

import com.basketteamapi.basketteam.models.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class PlayerControllerTest extends BaseControllerTest {

    @Autowired
    private PlayerController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    @WithMockUser(username = "testName2")
    void getPlayersList() throws Exception {
        registerMockUserAuth("testName2");

        Player player1 = new Player();
        player1.setName("player1");
        player1.setUserId(mockUserAuth.getId());

        Player player2 = new Player();
        player2.setName("player2");
        player2.setUserId(mockUserAuth.getId());

        mockHelperService.addPlayer(player1);
        mockHelperService.addPlayer(player2);

        mockMvc.perform(get("/v1/players/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(player1, player2))));
    }

    @Test
    void getPlayersListUnauthorized() throws Exception {
        mockMvc.perform(get("/v1/players/list"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "testName1")
    void addPlayer() throws Exception {
        registerMockUserAuth("testName1");
        mockMvc.perform(
                    post("/v1/players/add-player")
                        .content(objectMapper.writeValueAsString((new Player())))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addPlayerUnauthorized() throws Exception {
        mockMvc.perform(
                    post("/v1/players/add-player")
                        .content(objectMapper.writeValueAsString((new Player())))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "testName2")
    void updatePlayer() throws Exception {
        Player player2 = new Player();
        player2.setName("player2");

        mockHelperService.addPlayer(player2);

        mockMvc.perform(
                    put("/v1/players/update-player")
                        .content(objectMapper.writeValueAsString(player2))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updatePlayerUnauthorized() throws Exception {
        mockMvc.perform(
                        put("/v1/players/update-player")
                                .content(objectMapper.writeValueAsString((new Player())))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "testName4")
    void deletePlayer() throws Exception {
        Player player2 = new Player();
        player2.setName("player2");

        mockHelperService.addPlayer(player2);

        mockMvc.perform(
                        delete("/v1/players/delete-player")
                                .content(objectMapper.writeValueAsString(player2))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deletePlayerUnauthorized() throws Exception {
        mockMvc.perform(
                        delete("/v1/players/delete-player")
                                .content(objectMapper.writeValueAsString((new Player())))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}