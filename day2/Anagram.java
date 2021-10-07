package week1.day2;

/*
 * The Anagram program is to find both the given arrays have same values.
 * @author Anudeepika
 */
import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		/*
		 * Declare a String String text1 = "stops"; Declare another String String text2
		 * = "potss"; a) Check length of the strings are same then (Use A Condition) b)
		 * Convert both Strings in to characters c) Sort Both the arrays d) Check both
		 * the arrays has same value
		 */
		String text1 = "stops";
		String text2 = "potss";
		int count = 0;
		if (text1.length() == text2.length()) {
			char[] firstCharArray = text1.toCharArray();
			char[] SecondCharArray = text2.toCharArray();

			Arrays.sort(firstCharArray);
			Arrays.sort(SecondCharArray);
			for (int i = 0; i < firstCharArray.length; i++) {
				if (firstCharArray[i] != SecondCharArray[i]) {
					count++;
				}

			}
			if (count > 0) {
				System.out.println("Both the strings are not same");
			} else {
				System.out.println("Both the strings are same");
			}
		} else {
			System.out.println("Both the strings have different length, so the strings cannot be same");
		}
	}

}
