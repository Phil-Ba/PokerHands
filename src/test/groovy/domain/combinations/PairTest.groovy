package domain.combinations

import domain.Hand
import spock.lang.Specification
import spock.lang.Unroll

import static domain.StringToDomainParser.cardsFromString

/**
 * Created by philba.*/
class PairTest extends Specification {

	@Unroll
	def 'The pair with the higher pair value should win'() {
		def thisComb = new Pair(new Hand(cards: cardsFromString(cardsThis)))
		def otherComb = new Pair(new Hand(cards: cardsFromString(cardsOther)))

		expect:
		assert thisComb.compareTo(otherComb) == expected

		where:
		cardsThis        | cardsOther       || expected
		'Td Ts 9c 8c 7c' | 'Ac Ks Qh 1c 1s' || 1
		'Ac Ks Qh 1c 1s' | 'Td Ts 9c 8c 7c' || -1
		'Td Ts 9c 8c 7c' | 'Ac Ks Qh Tc Th' || -1
		'Td Ts 9c 8c 7c' | 'Td Ts 9c 8c 7c' || 0
	}

}
