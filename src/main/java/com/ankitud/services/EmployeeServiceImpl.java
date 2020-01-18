package com.ankitud.services;

import com.ankitud.domain.Employee;
import com.ankitud.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void removeEmployee(int empId) {
        Optional<Employee> opt = employeeRepository.findById(empId);
        if(opt.isPresent()){
            Employee emp = opt.get();
            employeeRepository.delete(emp);
        }
    }

    public Employee findEmployee(int empId){
        Optional<Employee> opt = employeeRepository.findById(empId);
        if(opt.isPresent())
            return opt.get();
        return null;
    }
}
