package com.spring;

import java.util.List;

public interface EmployeeDAO {
	
	public  void insertEmployee(Employee employee);
	
	public  List<Employee> getEmployees();

}
