package com.dao.impl;

import org.springframework.stereotype.Repository;

import com.common.domain.User;
import com.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao
{
    
    public UserDaoImpl()
    {
        super(User.class);
        // TODO Auto-generated constructor stub
    }
    
}
