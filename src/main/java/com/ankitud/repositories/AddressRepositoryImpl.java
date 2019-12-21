package com.ankitud.repositories;

import com.ankitud.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public void update(Address address) {
        String sql = "update address set city=:city , pincode=:pincode where addressId=:addressId";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(address);
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

}
