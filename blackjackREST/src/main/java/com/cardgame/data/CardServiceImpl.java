package com.cardgame.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardgame.entities.Card;
import com.cardgame.repositories.CardRepository;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardRepository cRepo;

	@Override
	public List<Card> index() {
		return cRepo.findAll();
	}

	@Override
	public Card create(Card jsonCard) {
		return cRepo.saveAndFlush(jsonCard);
	}

	@Override
	public Card show(int id) {
		return cRepo.findById(id).get();
	}

	@Override
	public Card replace(Card jsonCard, int id) {
		Card managedCard = cRepo.findById(id).get();

		managedCard.setDeck(jsonCard.getDeck());
		managedCard.setSuit(jsonCard.getSuit());
		managedCard.setRank(jsonCard.getRank());

		cRepo.flush();

		return cRepo.findById(id).get();
	}

	@Override
	public Card update(Card jsonCard, int id) {
		Card managedCard = cRepo.findById(id).get();

		if (jsonCard.getDeck().getId() != 0) {
			managedCard.setDeck(jsonCard.getDeck());
		}
		if (jsonCard.getSuit() != null && !jsonCard.getSuit().equals("")) {
			managedCard.setSuit(jsonCard.getSuit());
		}
		if (jsonCard.getRank() != null && !jsonCard.getRank().equals("")) {
			managedCard.setRank(jsonCard.getRank());
		}

		cRepo.flush();

		return cRepo.findById(id).get();
	}

	@Override
	public Boolean delete(int id) {
		cRepo.deleteById(id);
		if (cRepo.findById(id).isPresent()) {
			return false;
		}
		return true;
	}

	@Override
	public List<Card> findByPlayer(int playerId) {
		return cRepo.findByPlayerId(playerId);
	}

	// @Override
	// public ElectricBill replace(ElectricBill jsonBill, int id) {
	// ElectricBill managedBill = ebRepo.findById(id).get();
	//
	// managedBill.setCost(jsonBill.getCost());
	// managedBill.setYear(jsonBill.getYear());
	// managedBill.setWattage(jsonBill.getWattage());
	// managedBill.setManagerFirstName(jsonBill.getManagerFirstName());
	// managedBill.setManagerLastName(jsonBill.getManagerLastName());
	//
	// ebRepo.flush();
	//
	// return ebRepo.findById(id).get();
	// }

}
