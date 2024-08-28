package com.hexaware.hib;

import java.util.List;

public class EmployShowProjection {

	public static void main(String[] args) {
		EmployDaoImpl impl = new EmployDaoImpl();
		List<String> names = impl.showEmployProjection();
		for (String s : names) {
			System.out.println(s);
		}
	}
}
