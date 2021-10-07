package week1.day2;
/*
 * The CharOccurance program is to find number of time the given character is occurred in the string.
 * @author Anudeepika
 */
public class CharOccurance {

	public static void main(String[] args) {

		/*
		 * Check number of occurrences of a char (eg 'e') in a String declare and
		 * initialize a variable count to store the number of occurrences convert the
		 * string into char array get the length of the array traverse from 0 till the
		 * array length check the char array has the particular char in it if is has
		 * increment the count print the count out of the loop
		 */

		String str = "welcome to chennai";
		char letter = 'e';
		int count = 0;
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == letter) {
				count++;
			}
		}

		System.out.println("The letter '" + letter + "' is occured " + count + " times in the string '" + str + "'");
	}

}
