package week1.day2;

import java.util.Arrays;
/*
 * The FindSecondLargest program is to print the second largest number in the given array.
 * @author Anudeepika
 */
public class FindSecondLargest {

	public static void main(String[] args) {
		/*
		 1) Arrange the array in ascending order
		 2) Pick the 2nd element from the last and print it
		 */
		
		int[] data = {3,2,11,4,6,7};
		Arrays.sort(data);
		int length = data.length;
		System.out.println("The Second Largest number is "+data[length-2]);
		
	}

}
