package com.basketteamapi.basketteam.components.team;

import com.basketteamapi.basketteam.models.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    public ArrayList<ArrayList<TeamSize>> getTeamsSizes(int totalNumberPlayer) {
        return TeamsSizesConfig.getTeamsSizes(totalNumberPlayer);
    }

    public void distributionPlayersByTeams(List<Player> players, List<TeamSize> teamsSizes) {
        for (Player player : players) {
            System.out.println(player.toString());
        }

        for (TeamSize teamSize : teamsSizes) {
            System.out.println(teamSize.toString());
        }
    };
}
