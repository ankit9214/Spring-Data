package com.ankitud.services;

import com.ankitud.domain.Employee;
import com.ankitud.repositories.AddressRepository;
import com.ankitud.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="employeeService")
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    @Transactional
    public void updateEmployee(Employee employee) {

        //Method to update Employees new base location in employee table and address in address table

        employeeRepository.update(employee.getEmpId(), employee.getBaseLocation());

        addressRepository.update(employee.getAddress());

    }
}
