package com.basketteamapi.basketteam.controllers;

import com.basketteamapi.basketteam.components.player.PlayerService;
import com.basketteamapi.basketteam.components.team.TeamService;
import com.basketteamapi.basketteam.components.team.TeamSize;
import com.basketteamapi.basketteam.models.User;
import com.basketteamapi.basketteam.security.IAuthenticationFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/team")
public class TeamController {
    private final IAuthenticationFacade authFacade;
    private final TeamService teamService;

    private final PlayerService playerService;

    public TeamController(IAuthenticationFacade authFacade, TeamService teamService, PlayerService playerService) {
        this.authFacade = authFacade;
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @GetMapping(path = "teams-sizes")
    public List<TeamSize> getTeamsSizes() {
        User user = authFacade.getAuthUser();

        try {
            return teamService.getTeamsSizes(playerService.getTotalNumberPlayers(user.getId()));
        } catch (IOException exception) {
            return new ArrayList<>();
        }
    }
}
