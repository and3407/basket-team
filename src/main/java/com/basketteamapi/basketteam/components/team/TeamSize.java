package com.basketteamapi.basketteam.components.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TeamSize {
    private int quantityActivePlayers;
    private int quantityReservePlayers;
}
