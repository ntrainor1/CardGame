package com.cardgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardgame.entities.Player;

public interface PlayerRepo extends JpaRepository<Player, Integer> {

	Player findByName(String playername);

}
