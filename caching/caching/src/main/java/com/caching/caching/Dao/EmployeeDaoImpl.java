package com.caching.caching.Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.caching.caching.Entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	private static HashMap<Integer , Employee > employeeData = new HashMap<>();
	
//	Integer id = 8;
	
	@PostConstruct
	private void fillUsers() {
		employeeData.put(1,new Employee(1, "ram", "manager"));
		employeeData.put(2,new Employee(2, "ani", "engineer"));
		employeeData.put(3,new Employee(3, "abhi", "developer"));
		employeeData.put(4,new Employee(4, "mohan", "qa"));
		employeeData.put(5,new Employee(5, "aaditya", "auditer"));
		employeeData.put(6,new Employee(6, "yash", "ceo"));
		employeeData.put(7,new Employee(7, "ansh","engineer"));
	}
	
	@Override
	public Employee getEmployeeDetails(int id) {
		return employeeData.get(id);
	}

	@Override
	public List<Employee> getAllEmplyee() {
		Collection<Employee> employeeCollection = employeeData.values();
		Iterator<Employee> iterator = employeeCollection.iterator();
		List<Employee> employees = new ArrayList<>();
		while(iterator.hasNext()) {
			employees.add(iterator.next());
		}
		
		return employees;
	}

	@Override
	public Employee saveEmployeeDetails(Employee employee) {
		employeeData.put(employee.getId(),employee);
		return employee;
	}
}
