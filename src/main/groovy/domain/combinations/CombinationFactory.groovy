package domain.combinations

import domain.Card
import domain.Hand

/**
 * Created by pbayer.*/
class CombinationFactory {

	static List<? extends BaseCombination> fromHand(Hand hand) {
		List<? extends BaseCombination> combos = []
		if (hand.cards.groupBy(Card.valueClosure).max {
			it.value.size()
		}.value.size() > 1) {
			combos << new Pair(hand)
		}
		combos
	}

}
