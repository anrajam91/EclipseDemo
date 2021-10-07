package week1.day2;

import java.util.Arrays;
/*
 * The MissingElementInAnArray program is to print the missing number in the given array.
 * @author Anudeepika
 */
public class MissingElementInAnArray {

	public static void main(String[] args) {

		/*
		 * Initialize the input value to an array variable Sort the array loop through
		 * the array (start i from arr[0] till the length of the array) check if the
		 * iterator variable is not equal to the array values respectively print the
		 * number once printed break the iteration
		 */
		int[] arr = { 1, 2, 3, 4, 7, 6, 8 };

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			// System.out.println(arr[i]);
			int iteratorVar = i + 1;
			if (iteratorVar != arr[i]) {
				System.out.println("Missing Element in the array is " + iteratorVar);
				break;
			}
		}

	}

}
