package com.ankitud.domain;

public class Employee {

    private int empId;
    private String empName;
    private String department;
    private String baseLocation;

    public Employee(){

    }

    public Employee(int empId, String empName, String department, String baseLocation) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.baseLocation = baseLocation;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
