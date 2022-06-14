package com.basketteamapi.basketteam.security;

import lombok.Data;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Data
public class UserAuthToken {
    public String token;

    public UserAuthToken() {
    }

    public UserAuthToken(String token) {
        this.token = Base64.getEncoder().encodeToString(token.getBytes(StandardCharsets.UTF_8));
    }
}
