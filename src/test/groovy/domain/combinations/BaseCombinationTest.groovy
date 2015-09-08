package domain.combinations

import domain.Card
import domain.Hand
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by pbayer.*/
class BaseCombinationTest extends Specification {

	def "CompareTo"() {

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
		'5s 2h 9s 4c' || 9
	}

	private List<Card> cardsFromString(String cardString) {
		cardString.split(' ').collect {
			Card.fromString(it)
		}
	}
}
