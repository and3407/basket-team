package com.basketteamapi.basketteam.components.team;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TeamSize {
    private int quantityActivePlayers;
    private int quantityReservePlayers;

    public TeamSize() {}

    public TeamSize(int quantityActivePlayers, int quantityReservePlayers) {
        this.quantityActivePlayers = quantityActivePlayers;
        this.quantityReservePlayers = quantityReservePlayers;
    }
}
