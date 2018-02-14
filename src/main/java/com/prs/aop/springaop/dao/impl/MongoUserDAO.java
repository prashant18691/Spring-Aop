package com.prs.aop.springaop.dao.impl;

import com.prs.aop.springaop.dao.UserDAO;

import java.util.Arrays;
import java.util.List;

public class MongoUserDAO implements UserDAO

{

    public MongoUserDAO() {
        System.out.println("Mongo");
    }

    @Override

    public List<String> getAllUserNames()

    {

        System.out.println("**** Getting usernames from MongoDB *****");

        return Arrays.asList("Bond","James","Bond");

    }

}
