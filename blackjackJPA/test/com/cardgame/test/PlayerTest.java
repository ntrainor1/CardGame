package com.cardgame.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cardgame.entities.Player;

class PlayerTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Player player;
	
	@BeforeEach
	void setUp() {
		emf = Persistence.createEntityManagerFactory("BlackjackApp");
		em = emf.createEntityManager();
		player = em.find(Player.class, 1);
	}
	
	@Test
	@DisplayName("Test Player entity mapping")
	void test_player_mappings() {
		assertEquals("Dealer", player.getName());
		assertEquals(0, player.getWins());
		assertEquals("ACE", player.getHand().get(0).getRank());
		assertEquals("HEARTS", player.getHand().get(0).getSuit());
	}
	
	@Test
	@DisplayName("Test invalid Player entity")
	void test_invalid_player() {
		assertNull(em.find(Player.class, 15000));
	}
	
	@AfterEach
	void tearDown() {
		player = null;
		em = null;
		emf = null;
	}

}
