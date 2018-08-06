package com.cardgame.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardgame.entities.Card;
import com.cardgame.service.CardService;

@CrossOrigin({ "*", "http://localhost:4200" })
@RestController
@RequestMapping("api")
public class CardController {
	
	@Autowired
	private CardService cardService;

	@RequestMapping(path = "cart/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path = "cards", method=RequestMethod.GET)
	public List<Card> index(HttpServletRequest req, HttpServletResponse res) {
		return cardService.index();
	}
	
	@RequestMapping(path = "cards/{playername}/{id}", method = RequestMethod.GET)
	public Card show(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id, @PathVariable("playername") String playername) {
		return cardService.show(playername, id);
	}

}
