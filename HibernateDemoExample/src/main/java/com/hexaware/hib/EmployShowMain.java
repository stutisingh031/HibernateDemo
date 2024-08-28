package com.hexaware.hib;


	import java.util.List;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;

	public class EmployShowMain {

		public static void main(String[] args) {
			EmployDao dao = new EmployDaoImpl();
			List<Employ> employList = dao.showEmployDao();
			for (Employ employ : employList) {
				System.out.println(employ);
			}
			
		}
	}


