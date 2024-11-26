package com.sushavi.stats.controller;

import com.sushavi.stats.dto.PlayerDto;
import com.sushavi.stats.entity.Players;
import com.sushavi.stats.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/")
@Slf4j
public class PlayerController {

    private final PlayerService playerService;
    @GetMapping("/players")
    public List<Players> getPlayers(){
        return playerService.getPlayers();
    }

    @PostMapping("/save")
    public void savePlayer(@RequestBody PlayerDto playerDto){
        log.info("Entering inside savePlayer");
        try{
            Players createdPlayer = playerService.savePlayer(playerDto);
            log.info("Player [ {} - {} ] saved successfully", createdPlayer.getPlayerName(), createdPlayer.getPlayerId());
        } catch (Exception exception){
            log.error("Error found in saving the record", exception);
        }
    }
}
