package domain.combinations

import domain.Card
import domain.Hand
import spock.lang.Specification
import spock.lang.Unroll

import static test.TestUtils.cardsFromString

/**
 * Created by pbayer.*/
class BaseCombinationTest extends Specification {

	static int HIGH = 1
	static int EQUAL = 0
	static int LOW = -1
	static String baseHand = 'Ts 9c 7h 6d'

	@Unroll
	def '''If the value are not equal and this combination has a value of #combValueThis and the other combination
			has a value of #otherCombVa, compareTo should return #expected'''() {
		def thisComb = new BaseCombination(new Hand(cards: cardsFromString(baseHand)), combValueThis)
		def otherComb = new BaseCombination(new Hand(cards: cardsFromString('5D AD 1D 6d')), combValueOther)

		expect:
		assert thisComb.compareTo(otherComb) == expected

		where:
		combValueThis | combValueOther || expected
		1             | 2              || -1
		2             | 1              || 1
		-1            | 2              || -1
		-5            | -10            || 1
		100           | 23             || 1
	}

	@Unroll
	def "CompareTo should return #expected for #handcards if the value of both combinations are equal"() {
		int combinationValue = 0
		def baseComb = new BaseCombination(new Hand(cards: cardsFromString(baseHand)), combinationValue)
		def compareToComb = new BaseCombination(new Hand(cards: cardsFromString(handcards)), combinationValue)

		expect:
		assert baseComb.compareTo(compareToComb) == expected

		where:
		handcards     || expected
		'5D AD 1D 6d' || LOW
		'5D 4D 1D 2d' || HIGH
		'TD 9D 1D 2d' || HIGH
		'TD 8D 9D 6d' || LOW
		'TD 7D 9D 6d' || EQUAL
		baseHand      || EQUAL
	}

	@Unroll
	def "GetHighCard should return #expectedHighcard for the hand #handcards"() {
		def baseComb = new BaseCombination(new Hand(cards: cardsFromString(handcards)), 0)

		expect:
		baseComb.highCard == expectedHighcard

		where:
		handcards     || expectedHighcard
		'5D AD 1D'    || Card.ACE
		'Qc Qs Qs'    || Card.QUEEN
		'5s 2h 9d 4c' || 9
		'5s 2h 9c 4h' || 9
		'5s 2h 9h 4s' || 9
		'5c 2d 9s 4s' || 9
	}

}
