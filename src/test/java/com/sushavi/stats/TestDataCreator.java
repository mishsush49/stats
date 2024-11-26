package com.sushavi.stats;

import com.sushavi.stats.entity.Players;

import java.util.List;

public class TestDataCreator {
    public static TestDataCreator getInstance(){
        return new TestDataCreator();
    }
    public List<Players> getMockedPlayer() {
        return List.of(getPlayer(1L, "Sushant", "Batsman", 91L),
                getPlayer(2L, "Shlok", "Bowler", 44L),
                getPlayer(3L, "Madhavi", "Wicketkeeper", 91L));
    }

    private static Players getPlayer(long idPlayer, String playerName, String playerRole, long idCountry) {
        return Players.builder()
                .playerId(idPlayer)
                .playerName(playerName)
                .playerRole(playerRole)
                .idCountry(idCountry)
                .build();
    }
}
