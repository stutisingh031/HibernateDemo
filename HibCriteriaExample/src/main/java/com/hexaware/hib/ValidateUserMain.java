package com.hexaware.hib;

import java.util.Scanner;

public class ValidateUserMain {

	public static void main(String[] args) {
		String user, pwd;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter UserName and Password   ");
		user = sc.next();
		pwd = sc.next();
		EmployDao dao = new EmployDaoImpl();
		long count = dao.Validate(user, pwd);
		if (count==1) {
			System.out.println("Correct User");
		} else {
			System.out.println("Invalid User...");
		}
	}
}