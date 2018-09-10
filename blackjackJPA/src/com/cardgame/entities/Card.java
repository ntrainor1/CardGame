package com.cardgame.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Card {

	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "deck_id")
	private Deck deck;

	private String rank;

	private String suit;

	// Getters and Setters
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// HashCode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deck == null) ? 0 : deck.hashCode());
		result = prime * result + id;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (deck == null) {
			if (other.deck != null)
				return false;
		} else if (!deck.equals(other.deck))
			return false;
		if (id != other.id)
			return false;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		return true;
	}

	// To String
	@Override
	public String toString() {
		return "Card [id=" + id + ", deck=" + deck + ", rank=" + rank + ", suit=" + suit + "]";
	}

	// Constructors
	public Card(int id, Deck deck, String rank, String suit) {
		this.id = id;
		this.deck = deck;
		this.rank = rank;
		this.suit = suit;
	}

	public Card() {
	}

}
