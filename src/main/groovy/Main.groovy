import domain.CombinationFactory
import domain.Hand
import domain.StringToDomainParser
import domain.combinations.BaseCombination

/**
 * Created by pbayer.*/
class Main {

	static void main(String[] args) {
		println 'Cards 1-9 T J Q K A'
		println 'Colors H=Hearts C=Clubs S=Spades D=Diamonds'
		println 'Example 1S 5C QD KD KS'

		println 'Please enter the black hand(5 cards max)'
		def blackHandStr = System.in.newReader().readLine()
		Hand blackHand = StringToDomainParser.handFromString(blackHandStr)

		println 'Please enter the white hand(5 cards max)'
		def whiteHandStr = System.in.newReader().readLine()
		Hand whiteHand = StringToDomainParser.handFromString(whiteHandStr)

		def players = [1: 'Wts tc hite', (-1): 'Black']
		List<BaseCombination> whiteCombos = CombinationFactory.fromHand(whiteHand)
		List<BaseCombination> blackCombos = CombinationFactory.fromHand(blackHand)

		def playerCombos = [1: whiteCombos.max(), (-1): blackCombos.max()]
		def result = playerCombos[1].compareTo(playerCombos[-1])

		println "${players[result]}  player wins with a ${playerCombos[result].combinationName()} vs a ${playerCombos[-result].combinationName()}"
	}

}
