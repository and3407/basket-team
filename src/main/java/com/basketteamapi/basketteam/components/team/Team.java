package com.basketteamapi.basketteam.components.team;

import com.basketteamapi.basketteam.models.Player;
import lombok.Data;

@Data
public class Team {
    private Player[] players;
    private Player[] reservePlayers;
}
