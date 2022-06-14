package com.basketteamapi.basketteam.components.player.exceptions;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(String message) {
        super(message);
    }
}
