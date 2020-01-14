package com.ankitud.services;

import com.ankitud.domain.Employee;
import com.ankitud.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void insertEmployee(Employee employee) {
            employeeRepository.saveAndFlush(employee);
            System.out.println("Record saved successfuly!!");
    }

    @Override
    public void removeEmployee(int empId) {
            employeeRepository.deleteById(empId);
            System.out.println("Record deleted successfuly!!");
    }
}
