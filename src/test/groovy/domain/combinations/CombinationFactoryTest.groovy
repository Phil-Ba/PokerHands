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

	@Unroll
	def "FromHand contains a straight for the hand #handcards should be #isStraight"() {
		Hand hand = handFromString(handcards)

		expect:
		CombinationFactory.fromHand(hand).any { it.class == Straight } == isStraight

		where:
		handcards        || isStraight
		'AD JS 9D 8S 7S' || false
		'AD qS jD tS 7S' || false
		'AD qS kD td jS' || true
		'AD qS jD td 9S' || false
		'1D 2S 3D 4S 5S' || true
		'4D 6S 3D 5S 7S' || true
	}
}
