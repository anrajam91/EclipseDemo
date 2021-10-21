package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
	/**
	 * Declare a String as PayPal India 1.Convert it into a character array
	 * 2.Declare a Set as charSet for Character 3.Declare a Set as dupCharSet for
	 * duplicate Character 4.Iterate character array and add it into charSet 5.If
	 * the character is already in the charSet then, add it to the dupCharSet
	 * 6.Check the dupCharSet elements and remove those in the charSet 7.Iterate
	 * using charSet 8.Check the iterator variable isn't equals to an empty space
	 * 9.print it
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "PayPal India";
		char[] charArray = str.toCharArray();
		Set<Character> uniqSet = new LinkedHashSet<Character>();
		Set<Character> dupSet = new LinkedHashSet<Character>();
		for (char eachChar : charArray) {
			if (!uniqSet.add(eachChar)) {
				dupSet.add(eachChar);
			}

		}

		for (Character character : dupSet) {

			if (!Character.isWhitespace(character)) {
				if (uniqSet.contains(character)) {
					uniqSet.remove(character);
				}
			}
		}
		System.out.println("Unique letters in the given string: " + uniqSet);
		System.out.println("Duplicate letters removed from the given string: " + dupSet);

	}
}
