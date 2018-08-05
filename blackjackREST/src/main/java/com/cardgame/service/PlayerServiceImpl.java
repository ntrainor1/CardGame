// USER SERVICE IMPL WORKS DO NOT TOUCH

package com.cardgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardgame.entities.Player;
import com.cardgame.repository.PlayerRepo;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerRepo playerRepo;

	@Override
	public List<Player> index() {
		return playerRepo.findAll();
	}

	@Override
	public Player show(String playername, Integer id) {
		return playerRepo.findByName(playername);
	}

	@Override
	public Player create(Player player) {
		player.setWins(0);
		playerRepo.saveAndFlush(player);
		return null;
	}

	@Override
	public void destroy(String playername, int id) {
		playerRepo.deleteById(id);
	}

}
