package com.basketteamapi.basketteam.controllers;

import com.basketteamapi.basketteam.components.player.PlayerService;
import com.basketteamapi.basketteam.components.team.TeamService;
import com.basketteamapi.basketteam.components.team.TeamSize;
import com.basketteamapi.basketteam.models.User;
import com.basketteamapi.basketteam.security.IAuthenticationFacade;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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
    public ArrayList<ArrayList<TeamSize>> getTeamsSizes() {
        User user = authFacade.getAuthUser();
        return teamService.getTeamsSizes(playerService.getTotalNumberActivePlayers(user.getId()));
    }

    @GetMapping(path = "teams")
    public void getTeams(@RequestBody @NotNull ArrayList<TeamSize> teamsSizes) {
        User user = authFacade.getAuthUser();

        teamService.distributePlayersByTeams(
                playerService.getActivePlayers(user.getId()),
                teamsSizes
        );
    }
}
