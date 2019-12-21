package com.ankitud.repositories;

import com.ankitud.domain.Employee;

public interface EmployeeRepository {
    // Method to update Employee Base Location
    public void update(int empId, String baseLocation);
}
