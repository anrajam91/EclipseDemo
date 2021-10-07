package week1.day2;

/*call all the methods from Calculator and print the results*/
public class MyCalculator {

	public static void main(String[] args) {
		Calculator obj = new Calculator();
		int sumOfNum = obj.add(10, 20, 30);
		System.out.println("The sum of given numbers is " + sumOfNum);

		int subOfNum = obj.sub(25, 10);
		System.out.println("The subtracted value is " + subOfNum);

		double mulOfNum = obj.multiply(10, 10);
		System.out.println("The multiplied value of given numbers is " + mulOfNum);

		float divOfNum = obj.divide(250, 5);
		System.out.println("The quotient of given numbers is " + divOfNum);
	}

}
