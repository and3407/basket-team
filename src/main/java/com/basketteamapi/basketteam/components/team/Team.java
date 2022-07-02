package com.basketteamapi.basketteam.components.team;

import com.basketteamapi.basketteam.components.player.Player;
import lombok.Data;

@Data
public class Team {
    private Player[] players;
    private Player[] reservePlayers;
}
