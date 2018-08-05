package com.cardgame.service;

import java.util.List;

import com.cardgame.entities.Card;

public interface CardService {
	public List<Card> index();
	public Card show(String playername, Integer id);
	public Card create(Card card);
	public void destroy(String playername, int id);
}
