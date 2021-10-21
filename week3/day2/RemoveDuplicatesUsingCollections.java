package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesUsingCollections {
	/**
	 * /* Pseudo code
	 * 
	 * a) Use the declared String text as input String text = "We learn java basics
	 * as part of java sessions in java week1"; b) Initialize an integer variable as
	 * count c) Split the String into array and iterate over it d) Initialize
	 * another loop to check whether the word is there in the array e) if it is
	 * available then increase and count by 1. f) if the count > 1 then replace the
	 * word as "" g) Displaying the String without duplicate words
	 *
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "We learn java basics as part of java sessions in java week1";
		String newString = "";
		String dupWords = "";
		// int count=0;
		String[] split = text.split(" ");
		Set<String> wordSet = new LinkedHashSet<String>();

		for (String eachWord : split) {
			if (!wordSet.add(eachWord)) {
				wordSet.add("");
				dupWords = dupWords.concat(eachWord).concat(",");
			}

		}
		System.out.println("Unique words are: " + wordSet);
//System.out.println(count);
		for (String eachString : wordSet) {
			newString = newString.concat(eachString).concat(" ");
		}
		System.out.println("Duplicate words are: " + dupWords);
		System.out.println("**********************************");
		System.out.println("Printing the unique set as String: " + newString);

	}

}
