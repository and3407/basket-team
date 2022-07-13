package com.basketteamapi.basketteam.components.team;

import com.basketteamapi.basketteam.models.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistributionPlayersByTeams {
    private List<Player> players;
    private List<TeamSize> teamSizes;
    private List<Team> teams;

    public DistributionPlayersByTeams(List<Player> players, List<TeamSize> teamSizes) {
        this.players = players;
        this.teamSizes = teamSizes;
        this.teams = new ArrayList<>();
    }

    public List<Team> getTeams() {

        //проверка что у всех комманд максимальное кол-во игроков = кол-ву активных игроков юзера

        System.out.println(getRandomPlayer().getId());
        return teams;
    }

    private Player getRandomPlayer() {
        Collections.shuffle(players);

        return players.remove(0);
    }
}
