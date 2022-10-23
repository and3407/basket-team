package com.basketteamapi.basketteam.controllers;

import com.basketteamapi.basketteam.components.player.PlayerService;
import com.basketteamapi.basketteam.components.team.TeamGroup;
import com.basketteamapi.basketteam.components.team.TeamService;
import com.basketteamapi.basketteam.models.User;
import com.basketteamapi.basketteam.security.IAuthenticationFacade;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
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
    public ArrayList<TeamGroup> getTeamsSizes() {
        User user = authFacade.getAuthUser();
        return teamService.getTeamGroup(playerService.getTotalNumberActivePlayers(user.getId()));
    }

    @GetMapping(path = "teams")
    public TeamGroup getTeams(@RequestBody @NotNull TeamGroup teamGroup) {
        User user = authFacade.getAuthUser();

        return teamService.distributePlayersByTeams(
                playerService.getActivePlayers(user.getId()),
                teamGroup
        );
    }
}
