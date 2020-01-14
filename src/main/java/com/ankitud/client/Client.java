package com.ankitud.client;

import com.ankitud.domain.Employee;
import com.ankitud.services.EmployeeService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Client {

    public static void main(String args[]){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        Employee emp1 = new Employee(1001, "Susan", "Engineering");
        Employee emp2 = new Employee(1003, "Allen", "Account");

        employeeService.insertEmployee(emp1);
        employeeService.insertEmployee(emp2);

        System.out.println("Enter Employee Id to be deleted");
        Scanner scanner = new Scanner(System.in);

        int empId = scanner.nextInt();

        employeeService.removeEmployee(empId);

        scanner.close();
    }
}
