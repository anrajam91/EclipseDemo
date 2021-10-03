package week1.Day1;

public class FibonacciSeries {
	// This program prints Fibonacci series for the given range

	/* My Learning from this code:
	 * 1. How to assign dynamic value to the variable(assign derived value of one variable to another variable)
	 * 2. In looping statement, Adjusting the boundaries and increments as required
	 * 3. Shortcuts to show the in-built suggestions (Ctrl+space, enter)
	 */
	public static void main(String[] args) {

	// Declare the variables and assign initial values
		int range = 8;
		int firstNum = 0;
		int secNum = 1;
		int sum;
		
	// Print the initial values of first and second number of the series
		System.out.println(firstNum);
		System.out.println(secNum);

		for (int i = 1; i < range - 1; i++) 
		{
	// Add the number with the previous number and print the result
			sum = firstNum + secNum;
			firstNum = secNum;
			secNum = sum;
			System.out.println(sum);

		}

	}

}
