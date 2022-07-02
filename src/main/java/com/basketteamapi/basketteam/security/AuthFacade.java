package com.basketteamapi.basketteam.security;

import com.basketteamapi.basketteam.models.User;
import com.basketteamapi.basketteam.components.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthFacade implements IAuthenticationFacade {

    private final UserService userService;

    public AuthFacade(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public User getAuthUser() {
        return userService.getUserByUserName(getAuthentication().getName());
    }
}
