package domain

import spock.lang.Specification
import spock.lang.Unroll

import static domain.Color.*

/**
 * Created by pbayer.*/
class ColorTest extends Specification {

	@Unroll
	def 'Known value \'#testString\' should be converted correctly to #expectedColor'() {
		expect:
		expectedColor == Color.fromString(testString)

		where:
		testString || expectedColor
		's'        || Spades
		'S'        || Spades
		'h'        || Hearts
		'H'        || Hearts
		'D'        || Diamonds
		'd'        || Diamonds
		'C'        || Clubs
		'c'        || Clubs
	}

	def 'IllegalArgumentException should be thrown for an unknown value'(){
		when:
		Color.fromString('XXX')

		then:
		thrown IllegalArgumentException
	}
}
