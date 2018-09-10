package com.cardgame.data;

import java.util.List;

import com.cardgame.entities.Player;

public interface PlayerService {

	List<Player> index();

	Player create(Player jsonPlayer);

	Player show(int id);

	Player update(Player jsonPlayer, int id);

	Boolean delete(int id);
	
}
