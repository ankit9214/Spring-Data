package com.ankitud.services;

import com.ankitud.domain.Employee;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmployeeService {
    //Method to update Employee details such as address and base location
    void updateEmployee(Employee employee);
}
