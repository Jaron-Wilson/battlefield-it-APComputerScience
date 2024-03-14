/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card gooning = new Card("Queen","Spades",12);
		Card gooning2 = new Card("Ten","Hearts",10);
		Card gooning3 = new Card("Ace","Clubs",1);
		System.out.println(gooning.matches(gooning2));
		System.out.println(gooning2);
		System.out.println(gooning3.rank());
		System.out.println(gooning3.suit());
		System.out.println(gooning3.pointValue());
	}
}
