package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {
	/**
	 * 1) Arrange the array in ascending order 2) Pick the 2nd element from the last
	 * and print it 
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = { 3, 2, 11, 4, 6, 7 };
		Set<Integer> dataSet = new TreeSet<Integer>();
		for (int eachData : data) {
			dataSet.add(eachData);

		}
		System.out.println("Sorted array is: " + dataSet);
		List<Integer> dataList = new ArrayList<Integer>(dataSet);
		// System.out.println(dataList);
		System.out.println("Second Largest number in the array is: " + dataList.get(dataList.size() - 2));

	}

}
