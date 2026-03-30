package com.example.fantasy_football.repositories;

import com.example.fantasy_football.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    boolean existsByClubAndJerseyNumber(String club, Integer jerseyNumber);
}
