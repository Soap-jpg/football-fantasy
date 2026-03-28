package com.example.fantasy_football.controller;

import com.example.fantasy_football.model.Player;
import com.example.fantasy_football.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/public/players")
    public ResponseEntity<List<Player>> getPlayers(){
        return new ResponseEntity<>(playerService.getPlayers(), HttpStatus.OK);
    }

    @PostMapping("/admin/players")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player){
        Player savedPlayer = playerService.createPlayer(player);
        return new ResponseEntity<>(savedPlayer,HttpStatus.CREATED);
    }

    @PutMapping("/admin/players/{playerId}")
    public ResponseEntity<?> updatePlayer(@RequestBody Player player, @PathVariable Long playerId){
        try {
            Player savedPlayer = playerService.updatePlayer(player,playerId);
            return new ResponseEntity<>(savedPlayer,HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @DeleteMapping("/admin/players/{playerId}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long playerId) {
        try {
            playerService.deletePlayer(playerId);
            return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}
