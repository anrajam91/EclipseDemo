package week1.day2;

/*
 * The Palindrome program is to find the given string is palindrome or not.
 * @author Anudeepika
 */
public class Palindrome {

	public static void main(String[] args) {
		/*
		 * a) Declare A String value as"madam" b) Declare another String rev value as ""
		 * c) Iterate over the String in reverse order d) Add the char into rev e)
		 * Compare the original String with the reversed String, if it is same then
		 * print palinDrome f) Use .equalsIgnoreCase to compare a String
		 */

		String str = "madam";
		String rev = "";

		// System.out.println(length);

		char[] charArray = str.toCharArray();
		int length = charArray.length;
		for (int i = length - 1; i >= 0; i--) {
			rev = rev + charArray[i];

		}
		// System.out.println("The reversed string is "+rev);
		if (str.equalsIgnoreCase(rev)) {
			System.out.println("The given string '" + str + "' is a palindrome");
		}

		else {
			System.out.println("The given string '" + str + "' is NOT a palindrome");
		}
	}

}
