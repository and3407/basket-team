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

    public void distributePlayersByTeams(List<Player> players, List<TeamSize> teamsSizes) {
        DistributionPlayersByTeams distribution = new DistributionPlayersByTeams(players, teamsSizes);
        distribution.getTeams();
    };
}
