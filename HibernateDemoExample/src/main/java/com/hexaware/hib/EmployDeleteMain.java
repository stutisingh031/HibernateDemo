package com.hexaware.hib;

import java.util.Scanner;

public class EmployDeleteMain {

	public static void main(String[] args) {
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ No   ");
		empno = sc.nextInt();
		EmployDao dao = new EmployDaoImpl();
		System.out.println(dao.deleteEmployDao(empno));
	}
}