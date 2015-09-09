

/**
 * Created by pbayer.*/
class Main {

	static void main(String[] args) {
		println 'Cards 1-9 T J Q K A'
		println 'Colors H=Hearts C=Clubs S=Spades D=Diamonds'
		println 'Please enter the black hand(5 cards max)'
		def blackHand = System.in.newReader().readLine()
		println 'Please enter the white hand(5 cards max)'
		def whiteHand = System.in.newReader().readLine()
		println whiteHand + ' ' + blackHand
	}
}
