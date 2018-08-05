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

import com.cardgame.entities.Deck;

class DeckTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Deck deck;
	
	@BeforeEach
	void setUp() {
		emf = Persistence.createEntityManagerFactory("BlackjackApp");
		em = emf.createEntityManager();
		deck = em.find(Deck.class, 1);
	}
	
	@Test
	@DisplayName("Test Deck entity mapping")
	void test_deck_mappings() {
		assertEquals(52, deck.getCards().size());
		assertEquals("TWO", deck.getCards().get(0).getRank());
		assertEquals("HEARTS", deck.getCards().get(0).getSuit());
	}
	
	@Test
	@DisplayName("Test invalid Deck entity")
	void test_invalid_deck() {
		assertNull(em.find(Deck.class, 15000));
	}
	
	@AfterEach
	void tearDown() {
		deck = null;
		em = null;
		emf = null;
	}

}
