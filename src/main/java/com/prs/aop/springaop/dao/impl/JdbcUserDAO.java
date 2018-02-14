package com.prs.aop.springaop.dao.impl;

import com.prs.aop.springaop.dao.UserDAO;

import java.util.Arrays;
import java.util.List;

public class JdbcUserDAO implements UserDAO


{

    public JdbcUserDAO() {
        System.out.println("JDBC");
    }

    @Override

    public List<String> getAllUserNames()

    {

        System.out.println("**** Getting usernames from RDBMS *****");

        return Arrays.asList("Siva","Prasad","Reddy");

    }

}
