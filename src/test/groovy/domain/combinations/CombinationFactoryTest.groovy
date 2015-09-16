package domain.combinations

import domain.Hand
import spock.lang.Specification
import spock.lang.Unroll

import static domain.StringToDomainParser.handFromString

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
		'AD 8S 9D TS 8S' || true
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

	@Unroll
	def "FromHand contains a triple for the hand #handcards should be #isTriple"() {
		Hand hand = handFromString(handcards)

		expect:
		CombinationFactory.fromHand(hand).any { it.class == Triple } == isTriple

		where:
		handcards        || isTriple
		'AD JS 9D AS 7S' || false
		'7D qS jD tS 7S' || false
		'AD AS AD td jS' || true
		'AD qS jD td 9S' || false
		'1D 5S 3D 5S 5S' || true
		'4D 4S 4D 5S 7S' || true
	}

	@Unroll
	def "FromHand contains a Full House for the hand #handcards should be #isFullHouse"() {
		Hand hand = handFromString(handcards)

		expect:
		CombinationFactory.fromHand(hand).any { it.class == FullHouse } == isFullHouse

		where:
		handcards        || isFullHouse
		'AD JS 9D AS 7S' || false
		'7D qS jD tS 7S' || false
		'7D tS jD tS 7S' || false
		'AD AS AD td tS' || true
		'AD qS jD td 9S' || false
		'3D 5S 3D 5S 5S' || true
		'4D 5S 4D 5S 4S' || true
	}

	@Unroll
	def "FromHand contains Two Pairs for the hand #handcards should be #isTwoPair"() {
		Hand hand = handFromString(handcards)

		expect:
		CombinationFactory.fromHand(hand).any { it.class == TwoPairs } == isTwoPair

		where:
		handcards        || isTwoPair
		'AD 7S 9D AS 7S' || true
		'1D JS 9D JS 1S' || true
		'7D qS jD tS 7S' || false
		'AD AS AD Ad jS' || false
		'AD qS jD td 9S' || false
		'1D 5S 3D 1S 5S' || true
		'4D 4S 4D 5S 5S' || false
	}

	@Unroll
	def "FromHand contains a Flush for the hand #handcards should be #isFlush"() {
		Hand hand = handFromString(handcards)

		expect:
		CombinationFactory.fromHand(hand).any { it.class == Flush } == isFlush

		where:
		handcards        || isFlush
		'AC 7C 9C AC 7C' || true
		'1D JD 9D JD 1D' || true
		'7D qS jD tS 7S' || false
		'AD AS AD Ad jS' || false
		'AD qS jD td 9S' || false
		'1S 5S 3S 1S 5S' || true
		'4D 4S 4D 5S 5S' || false
	}

	@Unroll
	def "FromHand contains a RoyalFlush for the hand #handcards should be #isRoyalFlush"() {
		Hand hand = handFromString(handcards)

		expect:
		CombinationFactory.fromHand(hand).any { it.class == RoyalFlush } == isRoyalFlush

		where:
		handcards        || isRoyalFlush
		'AC 7C 9C AC 7C' || false
		'1D JD 9D JD 1D' || false
		'7D qS jD tS 7S' || false
		'AD AS AD Ad jS' || false
		'AD qS jD td 9S' || false
		'4D 4S 4D 5S 5S' || false
		'1S 4S 3S 5S 2S' || true
	}
}