package week3.day1;

public class DesktopAssignment1 extends ComputerAssignment1 {
	public void desktopSize() {
		System.out.println("Inside Desktop Size Method in 'Desktop' Class");
	}

	public static void main(String[] args) {

		DesktopAssignment1 obj = new DesktopAssignment1();
		obj.computerModel();
		obj.desktopSize();

	}

}
