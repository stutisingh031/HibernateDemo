package com.hexaware.hib;

import java.util.Scanner;

public class EmploySearchMain {

	public static void main(String[] args) {
		EmployDao dao = new EmployDaoImpl();
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ No   ");
		empno = sc.nextInt();
		Employ employ =dao.searchEmployDao(empno);
		if (employ!=null) {
			System.out.println(employ);
		}
	}
}
