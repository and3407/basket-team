package com.basketteamapi.basketteam.components.team;

import com.basketteamapi.basketteam.models.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.List;

@Service
public class TeamService {
    @SuppressWarnings("unchecked")
    public List<TeamSize> getTeamsSizes(int totalNumberPlayer) throws IOException {
        return (List<TeamSize>) (new ObjectMapper()).readValue(
                ResourceUtils.getFile("classpath:teamsSizes/" + totalNumberPlayer + "_players.json"),
                List.class
        );
    }

    public void distributionPlayersByTeams(Player[] players) {
    };
}
