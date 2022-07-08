package com.basketteamapi.basketteam.components.team;

import com.basketteamapi.basketteam.models.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeamService {
    public ArrayList<ArrayList<TeamSize>> getTeamsSizes(int totalNumberPlayer) {
        return TeamsSizesConfig.getTeamsSizes(totalNumberPlayer);
    }

    public void distributionPlayersByTeams(Player[] players) {
    };
}
