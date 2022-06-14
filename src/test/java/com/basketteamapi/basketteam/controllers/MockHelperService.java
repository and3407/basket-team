package com.basketteamapi.basketteam.controllers;

import com.basketteamapi.basketteam.components.player.Player;
import com.basketteamapi.basketteam.components.player.PlayerService;
import com.basketteamapi.basketteam.components.user.User;
import com.basketteamapi.basketteam.components.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MockHelperService {

    @Autowired
    private UserService userService;

    @Autowired
    private PlayerService playerService;

    public User createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return userService.addUser(userService.createBasicTokenAndPassword(user));
    }

    public Player addPlayer(Player player) {
        return playerService.addPlayer(player);
    }
}
