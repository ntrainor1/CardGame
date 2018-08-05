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

import com.cardgame.entities.Card;

class CardTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Card card;
	
	@BeforeEach
	void setUp() {
		emf = Persistence.createEntityManagerFactory("BlackjackApp");
		em = emf.createEntityManager();
		card = em.find(Card.class, 1);
	}
	
	@Test
	@DisplayName("Test Card entity mapping")
	void test_card_mappings() {
		assertEquals(1, card.getDeck().getId());
		assertEquals("TWO", card.getRank());
		assertEquals("HEARTS", card.getSuit());
		assertEquals(0, card.getPlayer().getWins());
		assertEquals("Dealer", card.getPlayer().getName());
	}
	
	@Test
	@DisplayName("Test invalid Card entity")
	void test_invalid_card() {
		assertNull(em.find(Card.class, 15000));
	}
	
	@AfterEach
	void tearDown() {
		card = null;
		em = null;
		emf = null;
	}

}
