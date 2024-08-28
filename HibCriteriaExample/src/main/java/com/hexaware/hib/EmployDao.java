package com.hexaware.hib;

import java.util.List;

public interface EmployDao {
	List<Employ> showEmployDao();
	Employ searchEmployDao(int empno);
	String addUser(UserData userData);
	long Validate(String user, String pwd);

}
