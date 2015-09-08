package domain

/**
 * Created by pbayer.*/
enum Color {

	Spades, Hearts, Diamonds, Clubs

	static Color fromString(String colorString) {
		switch (colorString.toLowerCase()) {
			case 's':
				return Spades
			case 'h':
				return Hearts
			case 'd':
				return Diamonds
			case 'c':
				return Clubs
		}
		throw new IllegalArgumentException('Unknown value ' + colorString)
	}
}