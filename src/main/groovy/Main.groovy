import domain.Hand
import domain.StringToDomainParser

/**
 * Created by pbayer.*/
class Main {

	static void main(String[] args) {
		println 'Cards 1-9 T J Q K A'
		println 'Colors H=Hearts C=Clubs S=Spades D=Diamonds'
		println 'Please enter the black hand(5 cards max)'
		println 'Example 1S 5C QD KD KS'

		def blackHandStr = System.in.newReader().readLine()
		Hand blackHand = StringToDomainParser.handFromString(blackHandStr)

		println 'Please enter the white hand(5 cards max)'
		def whiteHandStr = System.in.newReader().readLine()
		Hand whiteHand = StringToDomainParser.handFromString(whiteHandStr)

		println whiteHand + ' ' + blackHand

	}

}
