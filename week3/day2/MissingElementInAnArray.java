package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MissingElementInAnArray {
	/**
	 * Sort the array loop through the array (start i from arr[0] till the length of
	 * the array) check if the iterator variable is not equal to the array values
	 * respectively print the number once printed break the iteration @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 7, 6, 8 };
		Set<Integer> dataSet = new TreeSet<Integer>();
		for (int eachData : arr) {
			dataSet.add(eachData);
		}

		List<Integer> dataList = new ArrayList<Integer>(dataSet);
		for (int i = 1; i < dataList.size(); i++) {
			if (!(dataList.get(i - 1) == i)) {
				System.out.println("Missing Element is: " + i);
				break;
			}
		}

	}

}
