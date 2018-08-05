package com.cardgame.service;

import java.util.List;

import com.cardgame.entities.Player;

public interface PlayerService {
	public List<Player> index();
	public Player show(String playername, Integer id);
	public Player create(Player player);
	public void destroy(String playername, int id);
}
