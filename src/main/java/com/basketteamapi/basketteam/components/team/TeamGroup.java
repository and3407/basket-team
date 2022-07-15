package com.basketteamapi.basketteam.components.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class TeamGroup {
    private List<Team> teams = new ArrayList<>();

    public TeamGroup() {
    }

    public void appendTeam(Team team) {
        teams.add(team);
    }

    public int getTotalQuantityPlayers() {
        int totalQuantity = 0;

        for (Team team : teams) {
            totalQuantity += team.getMaxQuantityPlayers();
        }

        return totalQuantity;
    }
}
