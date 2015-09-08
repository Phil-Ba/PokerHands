package domain.combinations

import domain.Card
import domain.Hand

/**
 * Created by pbayer.*/
class BaseCombination implements Comparable<BaseCombination> {

	private final int value
	private final List<Card> cards
	private final int highCard

	BaseCombination(Hand hand, int value) {
		this.value = value
		cards = hand.cards
		highCard = cards.max {
			it.value
		}.value
	}

	@Override
	int compareTo(BaseCombination o) {
		if (o.value < value) {
			return 1
		} else if (o.value > value) {
			return -1
		}
	}

	int getHighCard() {
		return highCard
	}

	int getValue() {
		return value
	}
}