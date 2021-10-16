package week3.day1;

public class StringAssignment7 {
	public void indexPosition() {
		String text = "Java Exercise";

		System.out.println("The index position of Character 'E' is: " + text.indexOf('E'));
		System.out.println("The index position of Character 's' is: " + text.indexOf('s'));
		System.out.println("The character at Index position 5 is: " + text.charAt(5));
		System.out.println("The character at Index position 11 is: " + text.charAt(11));
	}

	public void compareStrings() {
		// TODO Auto-generated method stub
		String str1 = "I am Learning Java";
		String str2 = "I am learning java";

		if (str1 == str2) {
			System.out.println("Used == to validate. Both the strings are same");
		} else {
			System.out.println("Used == to validate. Both the strings are NOT same");
		}

		if (str1.equals(str2)) {
			System.out.println("Used '.equals' to validate. Both the strings are same");
		} else {
			System.out.println("Used '.equals' to validate. Both the strings are NOT same");
		}

		if (str1.equalsIgnoreCase(str2)) {
			System.out.println("Used '.equalsIgnoreCase' to validate. Both the strings are same");
		} else {
			System.out.println("Used '.equalsIgnoreCase' to validate. Both the strings are NOT same");
		}

	}

	public void manipulateString() {
		// TODO Auto-generated method stub
		String sentence = "I am working with Java8";
		String replace = sentence.replace("king", "Queen");
		System.out.println("Replaced characters from index 8 to 11. The resulted string is: " + replace);
		String substring = sentence.substring(5, 14);
		System.out.println("Printing characters from index 5 to 14 is: " + substring);
		String concat = sentence.concat("#");
		System.out.println("Added # to the existing string: " + concat);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringAssignment7 obj = new StringAssignment7();
		obj.indexPosition();
		System.out.println("***************End of Exercise 1***************");
		obj.compareStrings();
		System.out.println("***************End of Exercise 2***************");
		obj.manipulateString();
		System.out.println("***************End of Exercise 3***************");
	}

}
