package com.basketteamapi.basketteam.components.team;

import com.basketteamapi.basketteam.models.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    public ArrayList<TeamGroup> getTeamGroup(int totalNumberPlayer) {
        return TeamGroupConfig.getTeamGroup(totalNumberPlayer);
    }

    public void distributePlayersByTeams(List<Player> players, TeamGroup teamGroup) {
        DistributionPlayersByTeams distribution = new DistributionPlayersByTeams(players, teamGroup);

        for (Team team : distribution.getTeamGroup().getTeams()) {
            System.out.println(team.toString());
        }
    };
}
