/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
//		String[] ranks = {"jack", "queen", "king"};
//		String[] suits = {"blue", "red"};
//		int[] pointValues = {11, 12, 13};
//		Deck deck = new Deck(ranks, suits, pointValues);

		String [ ] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
		String [ ] suits = {"spades", "hearts", "diamonds", "clubs"};
		int [ ] pointValues = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
		Deck deck = new Deck(ranks, suits, pointValues);

//		System.out.println(deck.deal());
//		System.out.println(deck.size());
		System.out.println(deck);



	}
}
