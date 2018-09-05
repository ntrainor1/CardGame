package com.cardgame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardgame.data.CardService;
import com.cardgame.entities.Card;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class CardController {

	@Autowired
	private CardService cSI;

	// DONE
	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// DONE
	@RequestMapping(path = "cards", method = RequestMethod.GET)
	public List<Card> index() {
		return cSI.index();
	}

	// DONE
	@RequestMapping(path = "cards/{id}", method = RequestMethod.GET)
	public Card show(@PathVariable int id) {
		return cSI.show(id);
	}

	@RequestMapping(path = "cards", method = RequestMethod.POST)
	public Card create(@RequestBody Card jsonCard) {
		return cSI.create(jsonCard);
	}

	@RequestMapping(path = "cards/{id}", method = RequestMethod.PUT)
	public Card replace(@RequestBody Card jsonCard, @PathVariable int id) {
		return cSI.replace(jsonCard, id);
	}

	@RequestMapping(path = "cards/{id}", method = RequestMethod.PATCH)
	public Card update(@RequestBody Card jsonCard, @PathVariable int id) {
		return cSI.update(jsonCard, id);
	}

	@RequestMapping(path = "cards/{id}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable int id) {
		return cSI.delete(id);
	}

	@RequestMapping(path = "cards/search/player/{id}", method = RequestMethod.GET)
	public List<Card> findByPlayerId(@PathVariable int playerId) {
		return cSI.findByPlayer(playerId);
	}

}
