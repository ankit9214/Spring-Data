package com.ankitud.client;

import com.ankitud.config.AppConfig;
import com.ankitud.domain.Employee;
import com.ankitud.services.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


import java.util.Scanner;

public class Client {

    public static void main(String args[]){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
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
