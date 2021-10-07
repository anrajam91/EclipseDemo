package week1.day2;

import java.util.Arrays;

public class FindIntersection {

	public static void main(String[] args) {
		
		/*
		 * a) Declare An array for {3,2,11,4,6,7};	 
		 * b) Declare another array for {1,2,8,4,9,7};
		 * c) Declare for loop iterator from 0 to array length
		 * d) Declare a nested for another array from 0 to array length
		 * e) Compare Both the arrays using a condition statement
		 *  f) Print the first array (should match item in both arrays)
		 */
		
		int firstArr[] = {3,2,11,4,6,7};	
		int secondArr[] = {1,2,8,4,9,7};
		
		Arrays.sort(firstArr);
		Arrays.sort(secondArr);
		
		for (int i = 0; i < firstArr.length; i++) {
			for (int j = 0; j < secondArr.length; j++) {
				if(firstArr[i]==secondArr[j]) {
					System.out.println(firstArr[i]);
					 /*return statement is to exit the loop after printing the first array variable. 
					 * without return statement it will print all the matched numbers in the array
					 */
					//return;
				}
				
			}
			
		}
		
	}

}
