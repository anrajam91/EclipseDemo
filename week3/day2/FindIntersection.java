package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class FindIntersection {
	/*
	 * a) Declare An array for {3,2,11,4,6,7}; b) Declare another array for
	 * {1,2,8,4,9,7}; c) Declare for loop iterator from 0 to array length d) Declare
	 * a nested for another array from 0 to array length e) Compare Both the arrays
	 * using a condition statement * f) Print the first array (shoud match item in
	 * both arrays)
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 3, 2, 11, 4, 6, 7 };
		int[] arr2 = { 1, 2, 8, 4, 9, 7 };
		Set<Integer> dataSet1 = new LinkedHashSet<Integer>();
		Set<Integer> dataSet2 = new LinkedHashSet<Integer>();
		for (int data : arr1) {
			dataSet1.add(data);
		}
		for (int data1 : arr2) {
			if (!dataSet1.add(data1)) {
				dataSet2.add(data1);
			}

		}

		System.out.println("Items that match in both the arrays are: " + dataSet2);
	}

}
