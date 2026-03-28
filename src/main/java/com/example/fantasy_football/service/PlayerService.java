package com.example.fantasy_football.service;

import com.example.fantasy_football.model.Player;

import java.util.List;


public interface PlayerService {
    List<Player> getPlayers();
    Player createPlayer(Player player);
    Player updatePlayer (Player player, Long playerId);
    void deletePlayer(Long playerId);
}
