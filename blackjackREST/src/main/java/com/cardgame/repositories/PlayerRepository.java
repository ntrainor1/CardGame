package com.cardgame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardgame.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	
}
