package com.ankitud.services;

import com.ankitud.domain.Employee;

import java.util.List;

public interface EmployeeService {
    public void insertEmployee(Employee employee);
    public Employee findEmployee(int empId);
    public List<Employee> findAllEmployee();
    public long findEmployeeCount();
}
