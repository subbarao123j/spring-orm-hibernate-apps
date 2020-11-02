package com.spring;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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



	
	public void updateEmployee(Employee employee) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee updatedEmp =session.get(Employee.class, employee.getId());
		
		updatedEmp.setName(employee.getName());
		updatedEmp.setSalary(employee.getSalary());
		session.update(updatedEmp);
		transaction.commit();
		session.close();
		System.out.println("Done");
		
		
	}

}
