package com.basketteamapi.basketteam.components.user.exceptions;

public class UserNameIsBusyException extends RuntimeException {
    public UserNameIsBusyException(String message) {
        super("User name " + message + " is busy");
    }
}

