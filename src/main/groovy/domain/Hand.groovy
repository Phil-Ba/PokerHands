package domain

import groovy.transform.ToString

/**
 * Created by pbayer.*/
@ToString
class Hand {

	private List<Card> cards = []

	void addCard(Card card) {
		if (cards.size() == 5) {
			throw new IllegalArgumentException('A hand can only have a maximum of 5 cards!')
		}
		cards << card
	}

	List<Card> getCards() {
		return cards.asImmutable()
	}
}
