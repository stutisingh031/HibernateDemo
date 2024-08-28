package com.hexaware.hib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployDaoImpl implements EmployDao {

	SessionFactory sessionFactory;
	Session session;
	
	@Override
	public List<Employ> showEmployDao() {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Employ");
		List<Employ> employList = query.list();
		return employList;
	}

	@Override
	public Employ searchEmployDao(int empno) {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Employ where empno = "+empno);
		List<Employ> employList = query.list();
		return employList.get(0);
	}

	@Override
	public String addEmployDao(Employ employ) {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(employ);
		trans.commit();
		return "Employ Record Inserted...";
	}

	@Override
	public String updateEmployDao(Employ employ) {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(employ);
		trans.commit();
		return "Employ Record Updated...";
	}

	@Override
	public String deleteEmployDao(int empno) {
		Employ employ =searchEmployDao(empno);
		if (employ !=null) {
			sessionFactory = SessionHelper.getConnection();
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.delete(employ);
			trans.commit();
			return "Employ Record Deleted...";
		}
		return "Employ Record Not Found...";
	}

}