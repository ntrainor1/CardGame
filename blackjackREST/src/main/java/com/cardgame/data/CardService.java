package com.cardgame.data;

import java.util.List;

import com.cardgame.entities.Card;

public interface CardService {

	List<Card> index();

	Card create(Card jsonCard);

	Card show(int id);

	Card replace(Card jsonCard, int id);

	Card update(Card jsonCard, int id);

	Boolean delete(int id);

	List<Card> findByPlayer(int playerId);
	
}
