package com.caching.caching.Dao;

import com.caching.caching.Entity.Employee;
import java.util.List;

public interface EmployeeDao {

	Employee getEmployeeDetails(int employeeId);
	List<Employee> getAllEmplyee();
	Employee saveEmployeeDetails(Employee employee);
}
