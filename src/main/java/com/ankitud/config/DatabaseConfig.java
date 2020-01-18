package com.ankitud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.ankitud.repositories")
public class DatabaseConfig {

    @Bean
    public DataSource dataSource(Environment env){
        DriverManagerDataSource dmd = new DriverManagerDataSource();
        dmd.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dmd.setUrl(env.getProperty("jdbc.url"));
        dmd.setUsername(env.getProperty("jdbc.username"));
        dmd.setPassword(env.getProperty("jdbc.password"));

        return dmd;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(Environment env){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource(env));
        em.setPackagesToScan("com.ankitud");
        JpaVendorAdapter jva = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(jva);
        em.setJpaProperties(additionalProperties(env));
        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager jtm = new JpaTransactionManager();
        jtm.setEntityManagerFactory(emf);
        return jtm;
    }

    Properties additionalProperties(Environment env){
        Properties props = new Properties();
        props.setProperty("hibernate.dialect",env.getProperty("hibernate.dialect"));
        return props;
    }
}
