package com.cardgame.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardgame.entities.Player;
import com.cardgame.repositories.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository pRepo;

	@Override
	public List<Player> index() {
		return pRepo.findAll();
	}

	@Override
	public Player create(Player jsonPlayer) {
		jsonPlayer.setWins(0);
		return pRepo.saveAndFlush(jsonPlayer);
	}

	@Override
	public Player show(int id) {
		return pRepo.findById(id).get();
	}

	@Override
	public Player update(Player jsonPlayer, int id) {
		Player managedPlayer = pRepo.findById(id).get();

		if (jsonPlayer.getName() != null && !jsonPlayer.getName().isEmpty()) {
			managedPlayer.setName(jsonPlayer.getName());
		}

		pRepo.flush();

		return pRepo.findById(id).get();
	}

	@Override
	public Boolean delete(int id) {
		pRepo.deleteById(id);
		if (pRepo.findById(id).isPresent()) {
			return false;
		}
		return true;
	}

}
