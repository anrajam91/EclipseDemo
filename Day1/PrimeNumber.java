package week1.Day1;

public class PrimeNumber {
	// This program checks whether the number is prime or not

	/*
	 * My Learning from this code: 1. How to stop the loop from further executing ,
	 * when the condition reaches 2. How to use the flag to check the condition met
	 * or not 3. Difference between assigning the value to the variable(=) and check
	 * the value of the variable(==)
	 */
	
	public static void main(String[] args) {

	// Declare the variable and assign initial values to it
		int input = 97;
		boolean flag = false;
	// Iterate through for loop for the half of the input
		for (int i = 2; i < input / 2; i++) {
			// Get the remainder of the variable and proceed with the resulted value
			int remainder = input % i;
			if (remainder == 0) {
				flag = true;
				break;
			}
		}

	// Print the result with respect to the flag value
		if (flag == true) {
			System.out.println("Given number is not prime number");
		} else {
			System.out.println("Given number is prime number");
		}

	}

}
