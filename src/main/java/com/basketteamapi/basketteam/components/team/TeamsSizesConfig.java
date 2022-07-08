package com.basketteamapi.basketteam.components.team;

import com.basketteamapi.basketteam.components.team.exception.TeamSizeNotFoundException;

import java.util.ArrayList;

public class TeamsSizesConfig {
    public static ArrayList<ArrayList<TeamSize>> getTeamsSizes(int quantityPlayers) {
        ArrayList<ArrayList<TeamSize>> teamsSizes = new ArrayList<>();

        //1-2
        if (quantityPlayers == 3) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(1).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(2).build());
            teamsSizes.add(case_1);
        }

        //2-2
        if (quantityPlayers == 4) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(2).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(2).build());
            teamsSizes.add(case_1);
        }

        //2-3, 2/1-2
        if (quantityPlayers == 5) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(2).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(3).build());
            teamsSizes.add(case_1);

            ArrayList<TeamSize> case_2 = new ArrayList<>();
            case_2.add(TeamSize.builder().quantityActivePlayers(2).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(2).build());
            teamsSizes.add(case_2);
        }

        //3-3
        if (quantityPlayers == 6) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(3).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(3).build());
            teamsSizes.add(case_1);
        }

        //3-4, 3/1-3
        if (quantityPlayers == 7) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(3).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(4).build());
            teamsSizes.add(case_1);

            ArrayList<TeamSize> case_2 = new ArrayList<>();
            case_2.add(TeamSize.builder().quantityActivePlayers(3).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(3).build());
            teamsSizes.add(case_2);
        }

        //4-4
        if (quantityPlayers == 8) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(4).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(4).build());
            teamsSizes.add(case_1);
        }

        //4-5, 4/1-4
        if (quantityPlayers == 9) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(4).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            teamsSizes.add(case_1);

            ArrayList<TeamSize> case_2 = new ArrayList<>();
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            teamsSizes.add(case_2);
        }

        //5-5, 4/1-4/1
        if (quantityPlayers == 10) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            teamsSizes.add(case_1);

            ArrayList<TeamSize> case_2 = new ArrayList<>();
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            teamsSizes.add(case_2);
        }

        //5/1-5, 4-4-3, 3/1-3/1-3
        if (quantityPlayers == 11) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            teamsSizes.add(case_1);

            ArrayList<TeamSize> case_2 = new ArrayList<>();
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(3).build());
            teamsSizes.add(case_2);

            ArrayList<TeamSize> case_3 = new ArrayList<>();
            case_3.add(TeamSize.builder().quantityActivePlayers(3).quantityReservePlayers(1).build());
            case_3.add(TeamSize.builder().quantityActivePlayers(3).quantityReservePlayers(1).build());
            case_3.add(TeamSize.builder().quantityActivePlayers(3).build());
            teamsSizes.add(case_3);
        }

        //5/1-5/1, 4-4-4
        if (quantityPlayers == 12) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
            teamsSizes.add(case_1);

            ArrayList<TeamSize> case_2 = new ArrayList<>();
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            teamsSizes.add(case_2);
        }

        //4/1-4-4
        if (quantityPlayers == 13) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(4).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(4).build());
            teamsSizes.add(case_1);
        }

        //5-5-4, 4/1-4/1-4
        if (quantityPlayers == 14) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(4).build());
            teamsSizes.add(case_1);

            ArrayList<TeamSize> case_2 = new ArrayList<>();
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            teamsSizes.add(case_2);
        }

        //5-5-5, 4/1-4/1-4/1
        if (quantityPlayers == 15) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            teamsSizes.add(case_1);

            ArrayList<TeamSize> case_2 = new ArrayList<>();
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            teamsSizes.add(case_2);
        }

        //5/1-5-5, 4-4-4-4
        if (quantityPlayers == 16) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            teamsSizes.add(case_1);

            ArrayList<TeamSize> case_2 = new ArrayList<>();
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            teamsSizes.add(case_2);
        }

        //5/1-5/1-5, 4/1-4-4-4
        if (quantityPlayers == 17) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            teamsSizes.add(case_1);

            ArrayList<TeamSize> case_2 = new ArrayList<>();
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            teamsSizes.add(case_2);
        }

        //5-5-4-4, 5/1-5/1-5/1, 4/1-4/1-4-4
        if (quantityPlayers == 18) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(4).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(4).build());
            teamsSizes.add(case_1);

            ArrayList<TeamSize> case_2 = new ArrayList<>();
            case_2.add(TeamSize.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
            teamsSizes.add(case_2);

            ArrayList<TeamSize> case_3 = new ArrayList<>();
            case_3.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_3.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_3.add(TeamSize.builder().quantityActivePlayers(4).build());
            case_3.add(TeamSize.builder().quantityActivePlayers(4).build());
            teamsSizes.add(case_3);
        }

        //5-5-5-4, 4/1-4/1-4/1-4
        if (quantityPlayers == 19) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(4).build());
            teamsSizes.add(case_1);

            ArrayList<TeamSize> case_2 = new ArrayList<>();
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).build());
            teamsSizes.add(case_2);
        }

        //5-5-5-5, 4/1-4/1-4/1-4/1
        if (quantityPlayers == 20) {
            ArrayList<TeamSize> case_1 = new ArrayList<>();
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            case_1.add(TeamSize.builder().quantityActivePlayers(5).build());
            teamsSizes.add(case_1);

            ArrayList<TeamSize> case_2 = new ArrayList<>();
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            case_2.add(TeamSize.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
            teamsSizes.add(case_2);
        }

        if (teamsSizes.isEmpty()) {
            throw new TeamSizeNotFoundException("Активных игроков должно быть от 3 до 20");
        }

        return teamsSizes;
    }
}
