package com.cardgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardgame.entities.Deck;

public interface DeckRepo extends JpaRepository<Deck, Integer> {

}
