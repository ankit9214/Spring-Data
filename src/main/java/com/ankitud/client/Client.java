package com.ankitud.client;

import com.ankitud.domain.Address;
import com.ankitud.domain.Employee;
import com.ankitud.services.EmployeeService;
import com.ankitud.services.EmployeeServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.Scanner;

public class Client {
    static Logger logger = Logger.getLogger(Client.class);

    public static void main(String args[]){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);

        String baseLocation = "PUNE";
        int empId = 1001;

        Address addr = new Address(1001, "Phase 2, PUNE", "411057");
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee.setBaseLocation(baseLocation);
        employee.setAddress(addr);

        try{
            employeeService.updateEmployee(employee);
            System.out.println("Update Successful....");
        }
        catch (DataAccessException ex){
            logger.error(ex.getMessage(), ex);
        }

        context.close();

    }
}
