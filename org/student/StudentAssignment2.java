package org.student;

import org.department.DepartmentAssignment2;

public class StudentAssignment2 extends DepartmentAssignment2 {
	public void studentName() {
		// TODO Auto-generated method stub
		System.out.println("Inside Student Name method - Student Class");
	}

	public void studentDept() {
		// TODO Auto-generated method stub
		System.out.println("Inside Student Dept method - Student Class");
	}

	public void studentId() {
		// TODO Auto-generated method stub
		System.out.println("Inside Student ID method - Student Class");
	}

	public static void main(String[] args) {

		StudentAssignment2 obj = new StudentAssignment2();
		obj.collegeName();
		obj.collegeCode();
		obj.collegeRank();
		obj.deptName();
		obj.studentName();
		obj.studentDept();
		obj.studentId();

	}

}
