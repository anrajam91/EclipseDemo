package week1.day2;

/*
 * The FindTypes program is to find to find the count of each datatype values in the given string.
 * @author Anudeepika
 */
public class FindTypes {

	public static void main(String[] args) {
		/*
		 * a) Convert the String to character array b) Traverse through each character
		 * (using loop) c) Find if the given character is what data type e) print the
		 * count of each datatype values
		 * 
		 */

		String test = "$$ Welcome to 2nd Class of Automation $$ ";
		int letter = 0, space = 0, num = 0, specialChar = 0;
		char[] charArray = test.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isLetter(charArray[i])) {
				letter++;
			} else if (Character.isDigit(charArray[i])) {
				num++;
			} else if (Character.isSpaceChar(charArray[i])) {
				space++;
			} else {
				specialChar++;
			}
		}
		System.out.println("letter: " + letter);
		System.out.println("space: " + space);
		System.out.println("number: " + num);
		System.out.println("specialCharcter: " + specialChar);
	}

}
