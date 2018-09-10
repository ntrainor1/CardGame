package com.cardgame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardgame.data.PlayerService;
import com.cardgame.entities.Player;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class PlayerController {

	@Autowired
	private PlayerService pSI;

	// DONE
	@RequestMapping(path = "players/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// DONE
	@RequestMapping(path = "players", method = RequestMethod.GET)
	public List<Player> index() {
		return pSI.index();
	}

	// DONE
	@RequestMapping(path = "players/{id}", method = RequestMethod.GET)
	public Player show(@PathVariable int id) {
		return pSI.show(id);
	}

	// DONE
	@RequestMapping(path = "players", method = RequestMethod.POST)
	public Player create(@RequestBody Player jsonPlayer) {
		return pSI.create(jsonPlayer);
	}

	// DONE
	@RequestMapping(path = "players/{id}", method = RequestMethod.PATCH)
	public Player update(@RequestBody Player jsonPlayer, @PathVariable int id) {
		return pSI.update(jsonPlayer, id);
	}

	// DONE
	@RequestMapping(path = "players/{id}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable int id) {
		return pSI.delete(id);
	}

}
