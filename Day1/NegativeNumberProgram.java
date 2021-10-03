package week1.Day1;

public class NegativeNumberProgram {

	/*This program checks whether the number is negative/positive/neutral ,
	 * if the number is negative, it will convert to positive and displays the result.
	 */
	
	public static void main(String[] args) {

		int num = -10;
		if (num < 0) {
			// Checks the number is negative and print the result
			System.out.println("The number " + num + " is negative");
			// if the negative number, convert it into positive number
			int convertnum = num * -1;
			System.out.println("The number " + num + " is converted to " + convertnum);
		} else if (num > 0) {
			// Checks the number is positive and print the result
			System.out.println("The number " + num + " is positive");
		} else {
			System.out.println("The number " + num + " is neither positive nor negative");
		}

	}

}
