package week1.Day1;

public class Factorial {
	// This program prints the factorial for the given input

	/*
	 * My Learning from this code: 1. How to assign dynamic value to the
	 * variable(assign derived value to same variable) 2. To print the cumulative
	 * value , place the print statement outside of the loop 3. Shortcuts to show
	 * the in-built suggestions (Ctrl+space, enter)
	 */
	public static void main(String[] args) {

		// Assign the initial value to the variables
		int input = 6;
		int fact = 1;

		for (int i = 1; i <= input; i++) {
			// multiply the result value to the iterator for the given range
			fact = fact * i;
		}
		// prints the result
		System.out.println(fact);

	}

}
