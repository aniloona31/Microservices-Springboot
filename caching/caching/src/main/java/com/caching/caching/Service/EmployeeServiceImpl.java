package com.caching.caching.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caching.caching.Dao.EmployeeDao;
import com.caching.caching.Entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeRepository;

	@Override
	public Employee getEmployeeByID(int employeeId) {
		try {
			//trying to mimic a slow service
			Thread.sleep(5000);
		}catch(Exception e){
			e.printStackTrace();
		}
		return employeeRepository.getEmployeeDetails(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		try {
			Thread.sleep(5000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return employeeRepository.getAllEmplyee();
	}

	@Override
	public Employee saveEmployeeDetails(Employee employee) {
		employeeRepository.saveEmployeeDetails(employee);
		return employee;
	}
	
	
} 
