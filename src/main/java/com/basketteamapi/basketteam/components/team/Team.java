package com.basketteamapi.basketteam.components.team;

import com.basketteamapi.basketteam.models.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Team {
    private List<Player> activePlayers;
    private List<Player> reservePlayers;
    private int quantityActivePlayers = 0;
    private int quantityReservePlayers = 0;

    public Team() {}

    public int getMaxQuantityPlayers() {
        return quantityActivePlayers + quantityReservePlayers;
    }
}
