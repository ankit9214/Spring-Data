package com.ankitud.repositories;

import com.ankitud.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository(value="employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void update(int empId, String baseLocation) {
        String sql = "update employee set baseLocation = ?, empId = ?";
        jdbcTemplate.update(sql, baseLocation, empId);
    }
}
