package com.basketteamapi.basketteam.components.team;

import com.basketteamapi.basketteam.components.team.exception.NumberPlayersNotMatchNumberTeamGroup;
import com.basketteamapi.basketteam.models.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistributionPlayersByTeams {
    private final List<Player> players;
    private final TeamGroup teamGroup;

    public DistributionPlayersByTeams(List<Player> players, TeamGroup teamGroup) {
        this.players = players;
        this.teamGroup = teamGroup;
    }

    public TeamGroup getTeamGroup() {
        if (teamGroup.getTotalQuantityPlayers() != players.size()) {
            throw new NumberPlayersNotMatchNumberTeamGroup("Кол-во игроков не совпадает с кол-вом игроков в группе");
        }

        for (Team team : teamGroup.getTeams()) {
            fillCommand(team);
        }

        return teamGroup;
    }

    private Player getRandomPlayer() {
        Collections.shuffle(players);

        return players.remove(0);
    }

    private void fillCommand(Team team) {
        List<Player> activePlayers = new ArrayList<>();
        List<Player> reservePlayers = new ArrayList<>();

        for (int i = players.size(); i > 0; i--) {
            Player player = getRandomPlayer();

            if (team.getQuantityActivePlayers() > activePlayers.size()) {
                activePlayers.add(player);
                continue;
            }

            if (team.getQuantityReservePlayers() > reservePlayers.size()) {
                reservePlayers.add(player);
            }

            if (
                (team.getQuantityActivePlayers() == activePlayers.size()) &&
                (team.getQuantityReservePlayers() == reservePlayers.size())
            ) {
                break;
            }
        }

        team.setActivePlayers(activePlayers);
        team.setReservePlayers(reservePlayers);
    }
}
