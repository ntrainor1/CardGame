package com.cardgame.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardgame.entities.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {
	
}
