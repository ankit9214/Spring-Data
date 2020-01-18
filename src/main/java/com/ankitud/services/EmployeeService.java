package com.ankitud.services;

import com.ankitud.domain.Employee;

public interface EmployeeService {
    public void insertEmployee(Employee employee);
    public void removeEmployee(int empId);
    public Employee findEmployee(int empId);
}
