package week1.day2;
/*Create a class "Calculator" with below methods
(a) add(int num1, int num2, int num3), it should return sum of num1+num2+num3
(b) sub(int num1, int num2), it should return subtraction of of num1-num2
(c) mul(double num1, double num2), it should return product of num1 * num2
(d) divide(float num1, float num2), it should return division of num1 / num2
*/

public class Calculator {

	public int add(int num1, int num2, int num3) {
		int sum = num1 + num2 + num3;
		return sum;
	}

	public int sub(int num1, int num2) {
		int subVal = num1 - num2;
		return subVal;
	}

	public double multiply(double num1, double num2) {
		double mulValue = num1 * num2;
		return mulValue;
	}

	public float divide(float num1, float num2) {
		float div = num1 / num2;
		return div;
	}

}
