package com.hexaware.hib;

import java.util.List;

public class EmployShowMultiProjections {

	public static void main(String[] args) {
		EmployDaoImpl impl = new EmployDaoImpl();
		List<String> names = impl.showEmployMultiProjection();
		for (String s : names) {
			System.out.println(s);
		}
	}
}