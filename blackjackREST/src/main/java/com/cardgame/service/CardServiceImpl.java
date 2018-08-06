package com.cardgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardgame.entities.Card;
import com.cardgame.entities.Player;
import com.cardgame.repository.CardRepo;

@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardRepo cardRepo;

	@Override
	public List<Card> index() {
		return cardRepo.findAll();
	}

	@Override
	public Card show(String playername, Integer id) {
		return cardRepo.findById(id).get();
	}

	@Override
	public Card create(Card card) {
		return cardRepo.saveAndFlush(card);
	}

	@Override
	public void destroy(String playername, int id) {
		cardRepo.deleteById(id);
	}

}
