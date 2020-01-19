package com.ankitud.services;

import com.ankitud.domain.Employee;
import com.ankitud.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployee(int empId){
        Optional<Employee> opt = employeeRepository.findById(empId);
        if(opt.isPresent())
            return opt.get();
        return null;
    }

    @Override
    public long findEmployeeCount(){
        return employeeRepository.count();
    }
}
