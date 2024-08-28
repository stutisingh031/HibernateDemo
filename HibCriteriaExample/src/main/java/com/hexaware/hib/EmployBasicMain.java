package com.hexaware.hib;

import java.util.List;

public class EmployBasicMain {

	public static void main(String[] args) {
		EmployDaoImpl impl = new EmployDaoImpl();
		List<Employ> employList = impl.showEmployBasic();
		for (Employ employ : employList) {
			System.out.println(employ);
		}
	}
}
