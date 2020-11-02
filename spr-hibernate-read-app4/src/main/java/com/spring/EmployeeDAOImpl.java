package com.spring;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	public List<Employee> getEmployees() {

		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> list = criteria.list();

		return list;
	}

}
