package com.hexaware.hib;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class EmployDaoImpl implements EmployDao {

	@Override
	public List<Employ> showEmployDao() {
		SessionFactory sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employ.class);
		return criteria.list();
	}
	
	public List<String> showEmployProjection() {
		SessionFactory sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employ.class);
		Projection projection = Projections.property("name");
		criteria.setProjection(projection);
		List<String> names = criteria.list();
		return names;
	}
	
	public List<String> showEmployMultiProjection() {
		SessionFactory sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employ.class);
		Projection projection1 = Projections.property("name");
		Projection projection2 = Projections.property("dept");
//		Projection projection3 = Projections.property("gender");
//		Projection projection4 = Projections.property("basic");
		ProjectionList pList = Projections.projectionList();
		pList.add(projection1);
		pList.add(projection2);
//		pList.add(projection3);
//		pList.add(projection4);
		criteria.setProjection(pList);
	
		return criteria.list();
	}

	public List<Employ> showEmployBasic() {
		SessionFactory sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employ.class);
		criteria.addOrder(Order.desc("basic"));
		return criteria.list();
	}
	
	@Override
	public Employ searchEmployDao(int empno) {
		SessionFactory sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employ.class);
		criteria.add(Restrictions.eq("empno", empno));
		// from Employ where empno = 1
		Employ employ =(Employ) criteria.uniqueResult();
		return employ;
	}

	@Override
	public String addUser(UserData userData) {
		SessionFactory sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		String pwd = EncryptPassword.getCode(userData.getPassCode());
		userData.setPassCode(pwd);
		Transaction trans = session.beginTransaction();
		session.save(userData);
		trans.commit();
		return "User Added with Encrypted Password...";
	}

	@Override
	public long Validate(String user, String pwd) {
		SessionFactory sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		String passCode = EncryptPassword.getCode(pwd);
		Criteria cr = session.createCriteria(UserData.class);
		cr.add(Restrictions.eq("userName", user));
		cr.add(Restrictions.eq("passCode", passCode));
		cr.setProjection(Projections.rowCount());
		long count =(Long)cr.uniqueResult();
		System.out.println("Count is  " +count);
		return count;
	}

	
}