package week3.day1;

public class StudentsAssignment4 {
	public void getStudentInfo(int id) {
		// TODO Auto-generated method stub
		System.out.println("Inside getStudentInfo method - One argument- ID is: " + id);
	}

	public void getStudentInfo(int id, String name) {
		// TODO Auto-generated method stub
		System.out.println("Inside getStudentInfo method - Two arguments- ID is: " + id + " & Name is: " + name);
	}

	public void getStudentInfo(String email, long number) {
		// TODO Auto-generated method stub
		System.out.println(
				"Inside getStudentInfo method - Two arguments- Email is: " + email + " & Phone no. is " + number);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentsAssignment4 obj = new StudentsAssignment4();
		obj.getStudentInfo(1234);
		obj.getStudentInfo(1234, "Anu");
		obj.getStudentInfo("anu@123.com", 1234567890);
	}

}
