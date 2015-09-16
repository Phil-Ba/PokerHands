package domain
/**
 * Created by pbayer.*/

class StringToDomainParser {

	static List<Card> cardsFromString(String cardString) {
		cardString.split(' ').collect {
			Card.fromString(it)
		}
	}

	static Hand handFromString(String cardString) {
		new Hand(cards: cardsFromString(cardString))
	}

}
