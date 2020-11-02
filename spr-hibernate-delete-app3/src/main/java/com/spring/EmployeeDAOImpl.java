package com.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void insertEmployee(Employee employee) {

		sessionFactory.getCurrentSession().save(employee);

		System.out.println("Done");

	}

	@Override
	public void deleteEmployee(int id) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = session.get(Employee.class, id);

		if (employee != null) {
			session.delete(employee);
			transaction.commit();
			
			System.out.println();

		} else {

			System.out.println("No employee found");
		}

		session.close();
		System.out.println("Done");

	}

}
