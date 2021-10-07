package week1.day2;

/*
 * The ReverseEvenWords program is to reverse the even position words.
 * @author Anudeepika
 */
public class ReverseEvenWords {
	public static void main(String[] args) {

		/*
		 * Declare the input as Follow String test = "I am a software tester"; 
		 * split the words and have it in an array b) Traverse through each word (using loop)
		 * find the odd index within the loop (use mod operator)
		 * split the words and have it in an array
		 * print the even position words in reverse order using another loop (nested
		 * loop) 
		 * Convert words to character array if the position is even else print
		 * the word as it is(concatenate space at the end).
		 * 
		 */

		String test = "I am a software tester";
		String[] split = test.split(" ");
		String evenArr = "";

		for (int i = 0; i < split.length; i++) {
			if (i % 2 != 0) {
				char[] charArray = split[i].toCharArray();
				for (int j = charArray.length - 1; j >= 0; j--) {
					evenArr = evenArr + charArray[j];
				}
				System.out.print(evenArr + " ");
				evenArr = "";
			} else {
				System.out.print(split[i] + " ");
			}
		}
	}
}
