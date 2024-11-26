package com.sushavi.stats.service;

import com.sushavi.stats.dto.PlayerDto;
import com.sushavi.stats.entity.Players;
import com.sushavi.stats.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerService {

    @Value("${club.fetch.enabled}")
    private String clubFetchEnabledFlag;

    private final PlayerRepository playerRepository;

    public List<Players> getPlayers() {
        log.info("Entering inside getPlayers  -- clubFetchEnabledFlag : [{}] ", clubFetchEnabledFlag);
        List<Players> playersList = null;
        if("on".equals(clubFetchEnabledFlag)){
            playersList = (List<Players>) playerRepository.findAll();
            log.info("No of Players found :: {}", playersList.size());
        }
        return playersList;
    }

    public Players savePlayer(PlayerDto player) {
        Players requestedPlayer = getPlayer(player);
        playerRepository.save(requestedPlayer);
        return requestedPlayer;
    }

    private Players getPlayer(PlayerDto player) {
        return Players.builder()
                .playerName(player.getPlayerName())
                .playerRole(player.getPlayerRole())
                .idCountry(player.getIdCountry())
                .build();
    }
}
