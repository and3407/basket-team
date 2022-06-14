package com.basketteamapi.basketteam.controllers;

import com.basketteamapi.basketteam.components.user.User;
import com.basketteamapi.basketteam.components.user.UserService;
import com.basketteamapi.basketteam.security.IAuthenticationFacade;
import com.basketteamapi.basketteam.security.UserAuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private IAuthenticationFacade authFacade;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "user-name")
    public String getUserName() {
        User user = authFacade.getAuthUser();
        return user.getUsername();
    }

    @PostMapping(path = "register")
    public UserAuthToken register(@RequestBody User userData) {
        return userService.getUserAuthToken(
                userService.addUser(userService.createBasicTokenAndPassword(userData))
        );
    }

    @GetMapping(path = "ok")
    public String ok() {
        return "ok";
    }
}
