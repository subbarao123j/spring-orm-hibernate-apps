package com.spring;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				
				new AnnotationConfigApplicationContext(HibernateConfig.class);
		
		EmployeeDAO employeeDAO  = (EmployeeDAO)context.getBean("employeeDAO");
		
		Employee employee = new Employee();
		employee.setName("subba3");
		employee.setSalary(20000);
		employeeDAO.insertEmployee(employee);
		System.out.println("Employee "+employee.getName()+" inserted into DB successfully");
		
		List<Employee> empList=employeeDAO.getEmployees();
		

		for (Employee employee2 : empList) {

			System.out.println("Emp id =" + employee2.getId());
			System.out.println("Emp Name" + employee2.getName());
			System.out.println("Emp salary=" + employee2.getSalary());
		}
		
	
		
	}

}
