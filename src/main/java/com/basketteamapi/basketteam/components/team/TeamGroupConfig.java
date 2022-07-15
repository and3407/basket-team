package com.basketteamapi.basketteam.components.team;

import com.basketteamapi.basketteam.components.team.exception.TeamSizeNotFoundException;

import java.util.ArrayList;

public class TeamGroupConfig {
    public static ArrayList<TeamGroup> getTeamGroup(int quantityPlayers) {
        ArrayList<TeamGroup> teamGroups = new ArrayList<>();

        //1-2
        if (quantityPlayers == 3) {
            TeamGroup teamGroup = new TeamGroup();
            teamGroup.appendTeam(Team.builder().quantityActivePlayers(1).build());
            teamGroup.appendTeam(Team.builder().quantityActivePlayers(2).build());

            teamGroups.add(teamGroup);
        }

//        //2-2
//        if (quantityPlayers == 4) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(2).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(2).build());
//            teamGroups.add(case_1);
//        }
//
//        //2-3, 2/1-2
//        if (quantityPlayers == 5) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(2).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(3).build());
//            teamGroups.add(case_1);
//
//            ArrayList<TeamGroup> case_2 = new ArrayList<>();
//            case_2.add(TeamGroup.builder().quantityActivePlayers(2).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(2).build());
//            teamGroups.add(case_2);
//        }
//
//        //3-3
//        if (quantityPlayers == 6) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(3).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(3).build());
//            teamGroups.add(case_1);
//        }

//        //3-4, 3/1-3
//        if (quantityPlayers == 7) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(3).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            teamGroups.add(case_1);
//
//            ArrayList<TeamGroup> case_2 = new ArrayList<>();
//            case_2.add(TeamGroup.builder().quantityActivePlayers(3).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(3).build());
//            teamGroups.add(case_2);
//        }
//
//        //4-4
//        if (quantityPlayers == 8) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            teamGroups.add(case_1);
//        }
//
//        //4-5, 4/1-4
//        if (quantityPlayers == 9) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            teamGroups.add(case_1);
//
//            ArrayList<TeamGroup> case_2 = new ArrayList<>();
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            teamGroups.add(case_2);
//        }

//        //5-5, 4/1-4/1
//        if (quantityPlayers == 10) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            teamGroups.add(case_1);
//
//            ArrayList<TeamGroup> case_2 = new ArrayList<>();
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            teamGroups.add(case_2);
//        }

        //5/1-5, 4-4-3, 3/1-3/1-3
        if (quantityPlayers == 11) {
            TeamGroup teamGroup_1 = new TeamGroup();
            teamGroup_1.appendTeam(Team.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
            teamGroup_1.appendTeam(Team.builder().quantityActivePlayers(5).build());

            teamGroups.add(teamGroup_1);

            TeamGroup teamGroup_2 = new TeamGroup();
            teamGroup_2.appendTeam(Team.builder().quantityActivePlayers(4).build());
            teamGroup_2.appendTeam(Team.builder().quantityActivePlayers(4).build());
            teamGroup_2.appendTeam(Team.builder().quantityActivePlayers(3).build());

            teamGroups.add(teamGroup_2);

            TeamGroup teamGroup_3 = new TeamGroup();
            teamGroup_3.appendTeam(Team.builder().quantityActivePlayers(3).quantityReservePlayers(1).build());
            teamGroup_3.appendTeam(Team.builder().quantityActivePlayers(3).quantityReservePlayers(1).build());
            teamGroup_3.appendTeam(Team.builder().quantityActivePlayers(3).build());

            teamGroups.add(teamGroup_3);
        }

//        //5/1-5/1, 4-4-4
//        if (quantityPlayers == 12) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
//            teamGroups.add(case_1);
//
//            ArrayList<TeamGroup> case_2 = new ArrayList<>();
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            teamGroups.add(case_2);
//        }
//
//        //4/1-4-4
//        if (quantityPlayers == 13) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            teamGroups.add(case_1);
//        }
//
//        //5-5-4, 4/1-4/1-4
//        if (quantityPlayers == 14) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            teamGroups.add(case_1);
//
//            ArrayList<TeamGroup> case_2 = new ArrayList<>();
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            teamGroups.add(case_2);
//        }
//
//        //5-5-5, 4/1-4/1-4/1
//        if (quantityPlayers == 15) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            teamGroups.add(case_1);
//
//            ArrayList<TeamGroup> case_2 = new ArrayList<>();
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            teamGroups.add(case_2);
//        }
//
//        //5/1-5-5, 4-4-4-4
//        if (quantityPlayers == 16) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            teamGroups.add(case_1);
//
//            ArrayList<TeamGroup> case_2 = new ArrayList<>();
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            teamGroups.add(case_2);
//        }
//
//        //5/1-5/1-5, 4/1-4-4-4
//        if (quantityPlayers == 17) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            teamGroups.add(case_1);
//
//            ArrayList<TeamGroup> case_2 = new ArrayList<>();
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            teamGroups.add(case_2);
//        }
//
//        //5-5-4-4, 5/1-5/1-5/1, 4/1-4/1-4-4
//        if (quantityPlayers == 18) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            teamGroups.add(case_1);
//
//            ArrayList<TeamGroup> case_2 = new ArrayList<>();
//            case_2.add(TeamGroup.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(5).quantityReservePlayers(1).build());
//            teamGroups.add(case_2);
//
//            ArrayList<TeamGroup> case_3 = new ArrayList<>();
//            case_3.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_3.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_3.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            case_3.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            teamGroups.add(case_3);
//        }
//
//        //5-5-5-4, 4/1-4/1-4/1-4
//        if (quantityPlayers == 19) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            teamGroups.add(case_1);
//
//            ArrayList<TeamGroup> case_2 = new ArrayList<>();
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).build());
//            teamGroups.add(case_2);
//        }
//
//        //5-5-5-5, 4/1-4/1-4/1-4/1
//        if (quantityPlayers == 20) {
//            ArrayList<TeamGroup> case_1 = new ArrayList<>();
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            case_1.add(TeamGroup.builder().quantityActivePlayers(5).build());
//            teamGroups.add(case_1);
//
//            ArrayList<TeamGroup> case_2 = new ArrayList<>();
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            case_2.add(TeamGroup.builder().quantityActivePlayers(4).quantityReservePlayers(1).build());
//            teamGroups.add(case_2);
//        }

        if (teamGroups.isEmpty()) {
            throw new TeamSizeNotFoundException("Активных игроков должно быть от 3 до 20");
        }

        return teamGroups;
    }
}
