package com.example.fantasy_football.service;

import com.example.fantasy_football.exceptions.ResourceNotFoundException;
import com.example.fantasy_football.model.Player;
import com.example.fantasy_football.repositories.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Player player, Long playerId) {
        playerRepository.findById(playerId)
                .orElseThrow(()-> new ResourceNotFoundException("Player","playerId",playerId));

        player.setPlayerId(playerId);
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Long playerId) {
        Player playerExist = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player","playerId",playerId));
        playerRepository.delete(playerExist);
    }
}
