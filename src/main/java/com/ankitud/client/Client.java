package com.ankitud.client;

import com.ankitud.config.AppConfig;
import com.ankitud.domain.Employee;
import com.ankitud.services.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String args[]){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        Employee emp1 = new Employee(1001, "Susan", "Engineering");
        Employee emp2 = new Employee(1003, "Allen", "Account");

        employeeService.insertEmployee(emp1);
        employeeService.insertEmployee(emp2);

        System.out.println("Select one of the options : ");
        System.out.println("1. Find Employee Name using Id");
        System.out.println("2. Display all Employees");
        System.out.println("3. Display Employee count");

        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Enter Employee Id");
                Scanner scanner1 = new Scanner(System.in);
                int empId = scanner1.nextInt();
                Employee employee = employeeService.findEmployee(empId);
                System.out.println("Employee Name : " + employee.getEmpName());
                scanner1.close();
                break;
            case 2:
                List<Employee> emp = employeeService.findAllEmployee();
                emp.forEach(e -> System.out.println(e));
                break;
            case 3:
                System.out.println("Employee count : " + employeeService.findEmployeeCount());
                break;
            default:
                System.out.println("Wrong Option!!");
        }

        scanner.close();
        context.close();
    }
}
