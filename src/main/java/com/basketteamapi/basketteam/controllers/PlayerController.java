package com.basketteamapi.basketteam.controllers;

import com.basketteamapi.basketteam.components.player.exceptions.PlayerNotFoundException;
import com.basketteamapi.basketteam.models.Player;
import com.basketteamapi.basketteam.components.player.PlayerService;
import com.basketteamapi.basketteam.security.IAuthenticationFacade;
import com.basketteamapi.basketteam.models.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("v1/players")
public class PlayerController {

    private final IAuthenticationFacade authFacade;
    private final PlayerService playerService;

    public PlayerController(IAuthenticationFacade authFacade, PlayerService playerService) {
        this.authFacade = authFacade;
        this.playerService = playerService;
    }

    @GetMapping(path = "list")
    public List<Player> getPlayersList() {
        User user = authFacade.getAuthUser();

        return playerService.getList(user.getId());
    }

    @PostMapping(path = "add-player")
    public Player addPlayer(@RequestBody @NotNull Player player) {

        User user = authFacade.getAuthUser();

        player.setUserId(user.getId());

        return playerService.addPlayer(player);
    }

    @PutMapping(path = "update-player")
    public void updatePlayer(@RequestBody Player player) {playerService.updatePlayer(player);}

    @DeleteMapping(path = "delete-player")
    public void deletePlayer(@RequestBody Player player) {
        playerService.deletePlayer(player);
    }
}
