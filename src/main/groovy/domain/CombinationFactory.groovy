package domain

import domain.combinations.*
/**
 * Created by pbayer.*/
class CombinationFactory {

	/**
	 *
	 * @param hand
	 * @return
	 */
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

		if (hand.cards.countBy(Card.colorClosure).values().max() == 5) {
			combos << new Flush(hand)
		}

		if (cardValues.sum() == (minValue..(minValue + (cardValues.size() - 1))).sum()) {
			combos << new Straight(hand)
		}

		combineCombinations(hand, combos)
		if (combos.empty) {
			combos << new HighCard(hand)
		}


		combos
	}

	private static void combineCombinations(Hand hand, List<? extends BaseCombination> combos) {
		if (combos.count { it instanceof Pair } == 2) {
			combos << new TwoPairs(hand)
			return
		}

		if (combos.grep(Pair) && combos.grep(Triple)) {
			combos << new FullHouse(hand)
			return
		}

		if (combos.grep(Straight) && combos.grep(Flush)) {
			combos << new RoyalFlush(hand)
		}

	}
}
