package com.basketteamapi.basketteam.security;

import com.basketteamapi.basketteam.components.user.User;
import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
    Authentication getAuthentication();

    User getAuthUser();
}
