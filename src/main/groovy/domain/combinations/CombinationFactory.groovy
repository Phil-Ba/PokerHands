package domain.combinations

import domain.Card
import domain.Hand

/**
 * Created by pbayer.*/
class CombinationFactory {

	static List<? extends BaseCombination> fromHand(Hand hand) {
		List<Integer> cardValues = hand.cards.collect(Card.valueClosure)
		int minValue = cardValues.min()
		List<? extends BaseCombination> combos = []

		if (hand.cards.groupBy(Card.valueClosure).max {
			it.value.size()
		}.value.size() > 1) {
			combos << new Pair(hand)
		}

		if (cardValues.sum() == (minValue..(minValue + (cardValues.size() - 1))).sum()) {
			combos << new Straight(hand)
		}
		combos
	}

}
