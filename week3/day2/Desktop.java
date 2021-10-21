package week3.day2;

public class Desktop implements HardWare, Software {
	/**
	 * Assignment1 for multiple interface
	 */
	public void softwareResources() {
		// TODO Auto-generated method stub
		System.out.println("Inside Software Resources method");
	}

	public void hardwareResources() {
		// TODO Auto-generated method stub
		System.out.println("Inside Hardware Resources method");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Desktop obj = new Desktop();
		obj.softwareResources();
		obj.hardwareResources();
	}

}
