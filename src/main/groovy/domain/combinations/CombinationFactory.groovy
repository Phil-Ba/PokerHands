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

		hand.cards.groupBy(Card.valueClosure).each {
			switch (it.value.size()) {
				case 2:
					combos << new Pair(hand)
					break

				case 3:
					combos << new Triple(hand)
					break

				case 4:
					combos << new Poker(hand)
					break

				default:
					break
			}
		}

		if (cardValues.sum() == (minValue..(minValue + (cardValues.size() - 1))).sum()) {
			combos << new Straight(hand)
		}
		combos
	}

}
