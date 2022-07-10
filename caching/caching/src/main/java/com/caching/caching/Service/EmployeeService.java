package com.caching.caching.Service;


import java.util.List;

import com.caching.caching.Entity.Employee;

public interface EmployeeService {
    Employee getEmployeeByID(int employeeId);
    List<Employee> getAllEmployees();
    Employee saveEmployeeDetails(Employee employee);
}