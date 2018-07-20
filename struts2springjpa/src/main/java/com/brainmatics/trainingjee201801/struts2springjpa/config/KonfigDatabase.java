package com.brainmatics.trainingjee201801.struts2springjpa.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource("classpath:database.properties")
@EnableJpaRepositories("com.brainmatics.trainingjee201801.struts2springjpa.dao")
public class KonfigDatabase {
    
    @Value("${jdbc.class}") private String jdbcClass;
    @Value("${jdbc.url}") private String jdbcUrl;
    @Value("${jdbc.username}") private String jdbcUsername;
    @Value("${jdbc.password}") private String jdbcPassword;
    
    @Value("${hibernate.dialect}") private String hibernateDialect;
    @Value("${hibernate.hbm2ddl.auto}") private String hibernateHbm2Ddl;
    @Value("${hibernate.ejb.naming_strategy}") private String ejbNamingStrategy;
    @Value("${hibernate.show_sql}") private String showSql;
    @Value("${hibernate.format_sql}") private String formatSql;
    
    @Bean
    public DataSource inisialisasiDatasource(){
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(jdbcClass);
        dataSourceConfig.setJdbcUrl(jdbcUrl);
        dataSourceConfig.setUsername(jdbcUsername);
        dataSourceConfig.setPassword(jdbcPassword);
 
        return new HikariDataSource(dataSourceConfig);
    }
    
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.brainmatics.trainingjee201801.struts2springjpa");
 
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", hibernateDialect);
        jpaProperties.put("hibernate.hbm2ddl.auto", hibernateHbm2Ddl);
        jpaProperties.put("hibernate.ejb.naming_strategy", ejbNamingStrategy);
        jpaProperties.put("hibernate.show_sql", showSql);
        jpaProperties.put("hibernate.format_sql", formatSql);
 
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
 
        return entityManagerFactoryBean;
    }
    
    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
