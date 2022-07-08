package com.basketteamapi.basketteam.components.player.exceptions;

public class NotActivePlayersException extends RuntimeException{
    public NotActivePlayersException(String message) {
        super(message);
    }
}
