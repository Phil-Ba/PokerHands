package domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by pbayer.*/
@ToString
@EqualsAndHashCode
class Card {

	private static final Map<String, Integer> figureValues = ['T': TEN, 'J': JACK, 'Q': QUEEN, 'K': KING, 'A': ACE]
	static final int TEN = 10
	static final int JACK = 11
	static final int QUEEN = 12
	static final int KING = 13
	static final int ACE = 14

	def static final valueClosure = { Card c -> c.value}
	def static final colorClosure = { Card c -> c.color}

	Color color
	int value

	static Card fromString(String input) {
		if (input.size() != 2) {
			throw new IllegalArgumentException('A card must have exactly 2 characters!')
		}
		String valuePart = input[0].toUpperCase()
		String colorPart = input[1]
		Integer value
		try {
			value = valuePart.toInteger()
		} catch (NumberFormatException ex) {
			value = figureValues[valuePart]
			Objects.requireNonNull("Unkown value part '$valuePart'!")
		}
		return new Card(value: value, color: Color.fromString(colorPart))
	}
}
