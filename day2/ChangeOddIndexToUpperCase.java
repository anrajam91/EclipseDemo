package week1.day2;
/*
 * The ChangeOddIndexToUpperCase program is to change the character to uppercase, if the index is odd.
 * @author Anudeepika
 */

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {

		/*
		 * Declare String Input as Follow String test = "changeme"; a) Convert the
		 * String to character array b) Traverse through each character (using loop)
		 * c)find the odd index within the loop (use mod operator) d)within the loop,
		 * change the character to uppercase, if the index is odd else don't change
		 */
		String test = "changeme";
		String result = "";
		char[] charArray = test.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (i % 2 != 0) {

				charArray[i] = Character.toUpperCase(charArray[i]);
				// System.out.println(charArray[i]+" "+i);

			}
		}

		for (int i = 0; i < charArray.length; i++) {
			result = result + charArray[i];
		}
		System.out.println("The resulted string is " + result);
	}

}
