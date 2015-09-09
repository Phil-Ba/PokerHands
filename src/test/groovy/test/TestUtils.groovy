package test

import domain.Card
import domain.Hand

/**
 * Created by pbayer.*/

class TestUtils {

	static List<Card> cardsFromString(String cardString) {
		cardString.split(' ').collect {
			Card.fromString(it)
		}
	}

	static Hand handFromString(String cardString) {
		new Hand(cards: cardsFromString(cardString))
	}

}
