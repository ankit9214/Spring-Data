package com.ankitud.client;

import com.ankitud.domain.Employee;
import com.ankitud.services.EmployeeService;
import com.ankitud.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Client {

    public static void main(String args[]){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
    }
}
