package domain.combinations

import domain.Card
import domain.Hand

/**
 * Created by pbayer.*/
class BaseCombination implements Comparable<BaseCombination> {

	private final int value
	private final List<Card> cards
	private final int highCard

	BaseCombination(Hand hand, int value = 0 ) {
		this.value = value
		cards = hand.cards.collect()
		highCard = cards.max {
			it.value
		}.value
	}

	@Override
	final int compareTo(BaseCombination o) {
		if (o.value < value) {
			return 1
		} else if (o.value > value) {
			return -1
		}
		compareByHighcard(o)
	}

	private final int compareByHighcard(BaseCombination o) {
		def oValues = o.cards.collect { it.value }
		def thisValues = cards.collect { it.value }
		def uniqueOValues = oValues - thisValues
		def uniqueThisValues = thisValues - oValues
		println "maxThis: ${uniqueThisValues.max()} maxO: ${uniqueOValues.max()}"
		uniqueThisValues.max() <=> uniqueOValues.max()
	}

	int getHighCard() {
		return highCard
	}

	int getValue() {
		return value
	}

	@Override
	String toString() {
		"CombinationValue=$value; Cards= " + cards.collect { it.value }.sort { -it }.join(' : ')
	}
}