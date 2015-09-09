package domain.combinations

import domain.Hand
import spock.lang.Specification
import spock.lang.Unroll

import static test.TestUtils.handFromString

/**
 * Created by pbayer.*/
class CombinationFactoryTest extends Specification {

	@Unroll
	def "FromHand contains a pair for the hand #handcards should be #isPair"() {
		Hand hand = handFromString(handcards)

		expect:
		CombinationFactory.fromHand(hand).any { it.class == Pair } == isPair

		where:
		handcards        || isPair
		'AD JS 9D 8S 7S' || false
		'AD JS 9D AS 7S' || true
		'AD 8S 9D 8S 8S' || true
	}
}
