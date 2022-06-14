package com.basketteamapi.basketteam.components.services;

import com.basketteamapi.basketteam.components.player.Player;
import com.basketteamapi.basketteam.components.player.PlayerRepository;
import com.basketteamapi.basketteam.components.player.PlayerService;
import com.basketteamapi.basketteam.components.player.exceptions.PlayerNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PlayerServiceTest {
    @Mock
    private Player player;

    @Mock
    private PlayerRepository playerRepository;

    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        playerService = new PlayerService(playerRepository);
    }

    @Test
    void addPlayer() {
        Mockito.when(playerRepository.save(player)).thenReturn(player);

        Assertions.assertEquals(player, playerService.addPlayer(player));
    }

    @Test
    void getList() {

        List<Player> players = new ArrayList<>();
        players.add(player);

        Mockito
            .when(playerRepository.findAllByUserId(player.getId()))
            .thenReturn(players);

        Assertions.assertEquals(players, playerService.getList(player.getId()));
    }

    @Test
    void deletePlayer() {
        Mockito.when(playerRepository.existsById(player.getId())).thenReturn(true);
        Mockito.doNothing().when(playerRepository).delete(player);

        playerService.deletePlayer(player);
    }

    @Test
    void deletePlayerFail() {
        Player notExistPlayer = new Player();
        notExistPlayer.setId(99L);

        Mockito
            .when(playerRepository.existsById(notExistPlayer.getId()))
            .thenReturn(false);

        PlayerNotFoundException thrown = Assertions.assertThrows(
                PlayerNotFoundException.class,
                () -> {playerService.deletePlayer(notExistPlayer);}
        );

        Assertions.assertEquals(PlayerNotFoundException.class, thrown.getClass());
    }

    @Test
    void updatePlayer() {
        Mockito.when(playerRepository.existsById(player.getId())).thenReturn(true);
        Mockito.when(playerRepository.save(player)).thenReturn(player);

        playerService.addPlayer(player);
    }

    @Test
    void updatePlayerFail() {
        Player notExistPlayer = new Player();
        notExistPlayer.setId(99L);

        Mockito
            .when(playerRepository.existsById(notExistPlayer.getId()))
            .thenReturn(false);

        PlayerNotFoundException thrown = Assertions.assertThrows(
                PlayerNotFoundException.class,
                () -> {playerService.updatePlayer(notExistPlayer);}
        );

        Assertions.assertEquals(PlayerNotFoundException.class, thrown.getClass());
    }
}