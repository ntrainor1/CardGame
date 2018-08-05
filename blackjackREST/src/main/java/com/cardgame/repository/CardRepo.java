package com.cardgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardgame.entities.Card;

public interface CardRepo extends JpaRepository<Card, Integer> {

}
