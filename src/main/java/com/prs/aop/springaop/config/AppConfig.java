package com.prs.aop.springaop.config;

import com.prs.aop.springaop.dao.UserDAO;
import com.prs.aop.springaop.dao.impl.JdbcUserDAO;
import com.prs.aop.springaop.dao.impl.MongoUserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.prs.aop"})
public class AppConfig {
   /* @Bean
    public DataSource devDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("dev");
        dataSource.setUsername("dev");
        dataSource.setPassword("dev");
       return dataSource;
    }

    @Bean
    public DataSource prodDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("prod");
        dataSource.setUsername("prod");
        dataSource.setPassword("prod");
        return dataSource;
    }*/
    @Bean
    @DatabaseType("MYSQL")
    public UserDAO jdbcUserDAO(){

        return new JdbcUserDAO();

    }

    @Bean
    @DatabaseType("MONGO")
    public UserDAO mongoUserDAO(){

        return new MongoUserDAO();

    }

}
