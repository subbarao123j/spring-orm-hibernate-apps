package com.spring;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Transactional
	public void insertEmployee(Employee employee) {
		
		sessionFactory.getCurrentSession().save(employee);
		
		System.out.println("Done");

	}

}
