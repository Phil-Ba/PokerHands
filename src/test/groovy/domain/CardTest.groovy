package domain

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by pbayer.*/
class CardTest extends Specification {

	static {
		Color.Clubs.ordinal()
	}

	@Unroll
	def 'Test if #testString is converted correctly'() {
		expect:
		Card.fromString(testString) == expectedCard

		where:
		testString || expectedCard
		'1d'      || new Card(color: Color.Diamonds, value: 1)
		'6d'      || new Card(color: Color.Diamonds, value: 6)
		'Td'      || new Card(color: Color.Diamonds, value: Card.TEN)
		'TS'      || new Card(color: Color.Spades, value: Card.TEN)
		'JS'       || new Card(color: Color.Spades, value: Card.JACK)
		'QS'       || new Card(color: Color.Spades, value: Card.QUEEN)
		'kC'       || new Card(color: Color.Clubs, value: Card.KING)
		'ah'       || new Card(color: Color.Hearts, value: Card.ACE)

	}

	@Unroll
	def 'Test if illegal value #testString throws an exception'() {
		when:
		Card.fromString(testString)

		then:
		thrown expectedException

		where:
		testString || expectedException
		'11d'      || IllegalArgumentException
		'-d'       || IllegalArgumentException
		'Bd'       || IllegalArgumentException
		'dd'       || IllegalArgumentException
	}

}
